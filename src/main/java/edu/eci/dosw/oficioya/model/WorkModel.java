package edu.eci.dosw.oficioya.model;

import java.math.BigDecimal;
import java.util.List;

public class WorkModel {
    private Integer id;
    private BigDecimal approxRate;
    private Boolean availableNow;
    private String status;
    private int completeJobs;
    private Double averageRating;
    private TradeModel mainTrade;
    private List<TradeModel> secondaryTrades;
    private List<ZoneModel> zones;
    private List<AvailabilitySlotModel> availabilitySlots;
    private List<WorkPhotoModel> photos;

    public WorkModel() {
    }

    public WorkModel(Integer id, BigDecimal approxRate, Boolean availableNow, String status, int completeJobs,
                Double averageRating, TradeModel mainTrade, List<TradeModel> secondaryTrades, List<ZoneModel> zones,
                List<AvailabilitySlotModel> availabilitySlots, List<WorkPhotoModel> photos) {
        this.id = id;
        this.approxRate = approxRate;
        this.availableNow = availableNow;
        this.status = status;
        this.completeJobs = completeJobs;
        this.averageRating = averageRating;
        this.mainTrade = mainTrade;
        this.secondaryTrades = secondaryTrades;
        this.zones = zones;
        this.availabilitySlots = availabilitySlots;
        this.photos = photos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getApproxRate() {
        return approxRate;
    }

    public void setApproxRate(BigDecimal approxRate) {
        this.approxRate = approxRate;
    }

    public Boolean getAvailableNow() {
        return availableNow;
    }

    public void setAvailableNow(Boolean availableNow) {
        this.availableNow = availableNow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCompleteJobs() {
        return completeJobs;
    }

    public void setCompleteJobs(int completeJobs) {
        this.completeJobs = completeJobs;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public TradeModel getMainTrade() {
        return mainTrade;
    }

    public void setMainTrade(TradeModel mainTrade) {
        this.mainTrade = mainTrade;
    }

    public List<TradeModel> getSecondaryTrades() {
        return secondaryTrades;
    }

    public void setSecondaryTrades(List<TradeModel> secondaryTrades) {
        this.secondaryTrades = secondaryTrades;
    }

    public List<ZoneModel> getZones() {
        return zones;
    }

    public void setZones(List<ZoneModel> zones) {
        this.zones = zones;
    }

    public List<AvailabilitySlotModel> getAvailabilitySlots() {
        return availabilitySlots;
    }

    public void setAvailabilitySlots(List<AvailabilitySlotModel> availabilitySlots) {
        this.availabilitySlots = availabilitySlots;
    }

    public List<WorkPhotoModel> getPhotos() {
        return photos;
    }

    public void setPhotos(List<WorkPhotoModel> photos) {
        this.photos = photos;
    }
}
