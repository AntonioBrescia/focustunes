package com.focustunes.backend.sessions;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "focus_sessions")
public class FocusSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "start_time", nullable = false)
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "music_tag_id", nullable = false)
    private Long musicTagId;

    @Column(name = "place_tag_id", nullable = false)
    private Long placeTagId;

    @Column(name = "activity_tag_id", nullable = false)
    private Long activityTagId;

    @Column(name = "energy_start", nullable = false)
    private Byte energyStart;
    @Column(name = "focus_end")
    private Byte focusEnd; // 1..5 nullable

    @Column(name = "tasks_done", length = 200)
    private String tasksDone;

    @Column(name = "notes", columnDefinition = "text")
    private String notes;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt = Instant.now();

    @PreUpdate
    void onUpdate() {
        updatedAt = Instant.now();
    }

    // getters/setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Long getMusicTagId() {
        return musicTagId;
    }

    public void setMusicTagId(Long musicTagId) {
        this.musicTagId = musicTagId;
    }

    public Long getPlaceTagId() {
        return placeTagId;
    }

    public void setPlaceTagId(Long placeTagId) {
        this.placeTagId = placeTagId;
    }

    public Long getActivityTagId() {
        return activityTagId;
    }

    public void setActivityTagId(Long activityTagId) {
        this.activityTagId = activityTagId;
    }

    public Byte getEnergyStart() {
        return energyStart;
    }

    public void setEnergyStart(Byte energyStart) {
        this.energyStart = energyStart;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

}
