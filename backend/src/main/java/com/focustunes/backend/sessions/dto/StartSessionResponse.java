package com.focustunes.backend.sessions.dto;

import java.time.Instant;

public class StartSessionResponse {
    public Long sessionId;
    public Instant startTime;

    public StartSessionResponse(Long sessionId, Instant startTime) {
        this.sessionId = sessionId;
        this.startTime = startTime;
    }
}
