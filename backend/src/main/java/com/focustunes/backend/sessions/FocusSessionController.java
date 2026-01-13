package com.focustunes.backend.sessions;

import com.focustunes.backend.sessions.dto.StartSessionRequest;
import com.focustunes.backend.sessions.dto.StartSessionResponse;
import com.focustunes.backend.sessions.dto.StopSessionResponse;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/api/sessions")
public class FocusSessionController {

    private final FocusSessionRepository repo;

    public FocusSessionController(FocusSessionRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/start")
    public StartSessionResponse start(@Valid @RequestBody StartSessionRequest req) {
        FocusSession s = new FocusSession();
        s.setUserId(req.userId);
        s.setStartTime(Instant.now());
        s.setMusicTagId(req.musicTagId);
        s.setPlaceTagId(req.placeTagId);
        s.setActivityTagId(req.activityTagId);
        s.setEnergyStart(req.energyStart.byteValue());

        FocusSession saved = repo.save(s);
        return new StartSessionResponse(saved.getId(), saved.getStartTime());
    }

    @PostMapping("/{id}/stop")
    public StopSessionResponse stop(@PathVariable Long id) {
        FocusSession s = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found"));

        Instant end = Instant.now();
        s.setEndTime(end);

        long minutes = Math.max(1, Duration.between(s.getStartTime(), end).toMinutes());
        s.setDurationMinutes((int) minutes);

        repo.save(s);
        return new StopSessionResponse(s.getId(), s.getEndTime(), s.getDurationMinutes());
    }
}
