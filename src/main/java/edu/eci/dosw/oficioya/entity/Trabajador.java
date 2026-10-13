package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Trabajadores")
@PrimaryKeyJoinColumn(name = "id_trabajador")
public class Trabajador extends Usuario {

    @NotNull
    @Column(name = "status_available", nullable = false)
    private Boolean statusAvailable = false;

    @Column(name = "profile_photo")
    private byte[] profilePhoto;

    @NotNull
    @Column(name = "price_rate", nullable = false, precision = 9, scale = 2)
    private BigDecimal priceRate;

    @NotNull
    @Column(name = "promedio_reputacion", nullable = false)
    private Double promedioReputacion = 0.0;

    @NotNull
    @Column(name = "es_pausado", nullable = false)
    private Boolean esPausado = false;

    @NotNull
    @Column(name = "total_trabajos", nullable = false)
    private Long totalTrabajos = 0L;

    public Trabajador() {
        super();
    }

    public Trabajador(String email,
                      Long phone,
                      String username,
                      String full_name,
                      String password,
                      Boolean statusAvailable,
                      byte[] profilePhoto,
                      BigDecimal priceRate,
                      Double promedioReputacion,
                      Boolean esPausado,
                      Long totalTrabajos) {
        super(email, phone, username, full_name, password);
        this.statusAvailable = statusAvailable;
        this.profilePhoto = profilePhoto;
        this.priceRate = priceRate;
        this.promedioReputacion = promedioReputacion;
        this.esPausado = esPausado;
        this.totalTrabajos = totalTrabajos;
    }

    public Boolean getStatusAvailable() {
        return statusAvailable;
    }

    public void setStatusAvailable(Boolean statusAvailable) {
        this.statusAvailable = statusAvailable;
    }

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto ) {
        this.profilePhoto = profilePhoto;
    }

    public BigDecimal getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(BigDecimal priceRate) {
        this.priceRate = priceRate;
    }

    public Double getPromedioReputacion() {
        return promedioReputacion;
    }

    public void setPromedioReputacion(Double promedioReputacion) {
        this.promedioReputacion = promedioReputacion;
    }

    public Boolean getEsPausado() {
        return esPausado;
    }

    public void setEsPausado(Boolean esPausado) {
        this.esPausado = esPausado;
    }

    public Long getTotalTrabajos() {
        return totalTrabajos;
    }

    public void setTotalTrabajos(Long totalTrabajos) {
        this.totalTrabajos = totalTrabajos;
    }
}
