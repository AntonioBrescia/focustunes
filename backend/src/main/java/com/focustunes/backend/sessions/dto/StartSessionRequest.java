package com.focustunes.backend.sessions.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class StartSessionRequest {
    @NotNull
    public Long musicTagId;
    @NotNull
    public Long placeTagId;
    @NotNull
    public Long activityTagId;

    @Min(1)
    @Max(5)
    public Integer energyStart;

    @NotNull
    public Long userId; // TEMP: per ora lo mandiamo dal client. Con JWT lo togliamo.
}
