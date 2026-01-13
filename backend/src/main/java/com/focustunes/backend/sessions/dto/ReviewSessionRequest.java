package com.focustunes.backend.sessions.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReviewSessionRequest(
        @NotNull @Min(1) @Max(5) Integer focusEnd,
        @Size(max = 200) String tasksDone,
        @Size(max = 2000) String notes) {
}
