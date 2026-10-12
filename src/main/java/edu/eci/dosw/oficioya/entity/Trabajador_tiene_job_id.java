package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Trabajador_tiene_job_id implements Serializable {

    @Column(name = "id_trabajador")
    private Long id_trabajador;

    @Column(name = "id_job")
    private Long id_job;

    public Trabajador_tiene_job_id() {
    }

    public Trabajador_tiene_job_id(Long id_trabajador, Long id_job) {
        this.id_trabajador = id_trabajador;
        this.id_job = id_job;
    }

    public Long getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(Long id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public Long getId_job() {
        return id_job;
    }

    public void setId_job(Long id_job) {
        this.id_job = id_job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Trabajador_tiene_job_id that))
            return false;
        return Objects.equals(id_trabajador, that.id_trabajador) &&
                Objects.equals(id_job, that.id_job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_trabajador, id_job);
    }
}