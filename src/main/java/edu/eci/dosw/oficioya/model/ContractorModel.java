package edu.eci.dosw.oficioya.model;

public class ContractorModel {
    private Integer id;
    private Double averageRating;

    public ContractorModel() {
    }

    public ContractorModel(Integer id, Double averageRating) {
        this.id = id;
        this.averageRating = averageRating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
