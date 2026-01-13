package com.focustunes.backend.sessions.dto;

import java.time.Instant;

public class StopSessionResponse {
    public Long sessionId;
    public Instant endTime;
    public Integer durationMinutes;

    public StopSessionResponse(Long sessionId, Instant endTime, Integer durationMinutes) {
        this.sessionId = sessionId;
        this.endTime = endTime;
        this.durationMinutes = durationMinutes;
    }
}
