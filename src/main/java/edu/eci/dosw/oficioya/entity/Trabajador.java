package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trabajador_tiene_job> jobs = new ArrayList<>();

    public Trabajador() {
        super();
    }

    public Trabajador(String email, 
                      Long phone, 
                      String username, 
                      String fullName, 
                      String password,
                      Boolean statusAvailable, 
                      byte[] profilePhoto, 
                      BigDecimal priceRate, 
                      Double promedioReputacion, 
                      Boolean esPausado, 
                      Long totalTrabajos) {
        super(email, phone, username, fullName, password);
        this.statusAvailable = statusAvailable;
        this.profilePhoto = profilePhoto;
        this.priceRate = priceRate;
        this.promedioReputacion = promedioReputacion;
        this.esPausado = esPausado;
        this.totalTrabajos = totalTrabajos;
    }

    public void agregarJob(Job job, boolean esPrincipal) {
        Trabajador_tiene_job trabajador_tiene_job = new Trabajador_tiene_job(this, job, esPrincipal);
        this.jobs.add(trabajador_tiene_job);
    }

    public List<Trabajador_tiene_job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Trabajador_tiene_job> jobs) {
        this.jobs = jobs;
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

    public void setProfilePhoto(byte[] profilePhoto) {
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