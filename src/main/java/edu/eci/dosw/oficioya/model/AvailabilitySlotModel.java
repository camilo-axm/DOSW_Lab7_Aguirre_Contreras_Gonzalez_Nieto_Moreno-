package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class AvailabilitySlotModel {
    private Integer id;
    private Date dayOfWeek;
    private LocalTime startTime;
    private LocalDateTime endTime;

    public AvailabilitySlotModel() {
    }

    public AvailabilitySlotModel(Integer id, Date dayOfWeek, LocalTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Date dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
