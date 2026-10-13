package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Contratantes")
public class Contratante {

    @Id
    @Column(name = "id_contratante")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "id_contratante")
    private Usuario usuario;

    @Column(name = "promedio_reputacion")
    private Double promedioReputacion = 0.0;

    public Contratante() {
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

    public Double getPromedioReputacion() {
        return promedioReputacion;
    }

    public void setPromedioReputacion(Double promedioReputacion) {
        this.promedioReputacion = promedioReputacion;
    }
}
