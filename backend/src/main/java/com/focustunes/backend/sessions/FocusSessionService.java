package com.focustunes.backend.sessions;

import com.focustunes.backend.sessions.dto.ReviewSessionRequest;
import com.focustunes.backend.sessions.dto.ReviewSessionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
public class FocusSessionService {

    private final FocusSessionRepository repository;

    public FocusSessionService(FocusSessionRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ReviewSessionResponse reviewSession(Long id, ReviewSessionRequest req) {
        FocusSession session = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found"));

        // ✅ deve essere stoppata prima
        if (session.getEndTime() == null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Session must be stopped before review");
        }

        // (scelta MVP) review modificabile: aggiorno sempre
        session.setFocusEnd(req.focusEnd().byteValue());
        session.setTasksDone(req.tasksDone());
        session.setNotes(req.notes());
        session.setReviewedAt(Instant.now());

        repository.save(session);

        return new ReviewSessionResponse(
                session.getId(),
                session.getReviewedAt(),
                session.getFocusEnd() == null ? null : session.getFocusEnd().intValue(),
                session.getTasksDone(),
                session.getNotes());
    }
}
