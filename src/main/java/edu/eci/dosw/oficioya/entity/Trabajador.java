package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Trabajadores")
public class Trabajador {

    @Id
    @Column(name = "id_trabajador")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_trabajador")
    private Usuario usuario;

    @NotNull
    @Column(name = "status_available", nullable = false)
    private Boolean statusAvailable = false;

    @Column(length = 20)
    private String status;

    @NotNull
    @Column(name = "price_rate", nullable = false, precision = 9, scale = 2)
    private BigDecimal priceRate;

    @NotNull
    @Column(name = "promedio_reputacion", nullable = false)
    private Double promedioReputacion = 0.0;

    @NotNull
    @Column(name = "total_trabajos", nullable = false)
    private Long totalTrabajos = 0L;

    @OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trabajador_tiene_job> jobs = new ArrayList<>();

    public Trabajador() {
    }

    public void agregarJob(Job job, boolean esPrincipal) {
        this.jobs.add(new Trabajador_tiene_job(this, job, esPrincipal));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getStatusAvailable() {
        return statusAvailable;
    }

    public void setStatusAvailable(Boolean statusAvailable) {
        this.statusAvailable = statusAvailable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Long getTotalTrabajos() {
        return totalTrabajos;
    }

    public void setTotalTrabajos(Long totalTrabajos) {
        this.totalTrabajos = totalTrabajos;
    }

    public List<Trabajador_tiene_job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Trabajador_tiene_job> jobs) {
        this.jobs = jobs;
    }
}
