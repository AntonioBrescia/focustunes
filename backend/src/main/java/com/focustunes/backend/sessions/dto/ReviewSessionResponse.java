package com.focustunes.backend.sessions.dto;

import java.time.Instant;

public record ReviewSessionResponse(
        Long sessionId,
        Instant reviewedAt,
        Integer focusEnd,
        String tasksDone,
        String notes) {
}
