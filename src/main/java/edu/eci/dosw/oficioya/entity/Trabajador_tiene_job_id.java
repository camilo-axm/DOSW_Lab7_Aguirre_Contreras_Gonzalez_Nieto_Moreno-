package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Trabajador_tiene_job_id implements Serializable {

    @Column(name = "id_trabajador")
    private Long idTrabajador;

    @Column(name = "id_job")
    private Long idJob;

    public Trabajador_tiene_job_id() {
    }

    public Trabajador_tiene_job_id(Long idTrabajador, Long idJob) {
        this.idTrabajador = idTrabajador;
        this.idJob = idJob;
    }

    public Long getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Trabajador_tiene_job_id that))
            return false;
        return Objects.equals(idTrabajador, that.idTrabajador) &&
                Objects.equals(idJob, that.idJob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrabajador, idJob);
    }
}
