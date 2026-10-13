package edu.eci.dosw.oficioya.entity;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;



@Entity

@Table(name = "trabajador_tiene_job")

public class Trabajador_tiene_job {



    @EmbeddedId

    private Trabajador_tiene_job_id id = new Trabajador_tiene_job_id();



    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @MapsId("idTrabajador")

    @JoinColumn(name = "id_trabajador", nullable = false)

    private Trabajador trabajador;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @MapsId("idJob")

    @JoinColumn(name = "id_job", nullable = false)

    private Job job;



    @NotNull

    @Column(name = "es_principal", nullable = false)

    private Boolean esPrincipal = false;



    public Trabajador_tiene_job() {

    }



    public Trabajador_tiene_job(Trabajador trabajador, Job job, Boolean esPrincipal) {

        this.trabajador = trabajador;

        this.job = job;

        this.esPrincipal = esPrincipal;

    }



    public Trabajador_tiene_job_id getId() {

        return id;

    }



    public Trabajador getTrabajador() {

        return trabajador;

    }



    public void setTrabajador(Trabajador trabajador) {

        this.trabajador = trabajador;

    }



    public Job getJob() {

        return job;

    }



    public void setJob(Job job) {

        this.job = job;

    }



    public Boolean getEsPrincipal() {

        return esPrincipal;

    }



    public void setEsPrincipal(Boolean esPrincipal) {

        this.esPrincipal = esPrincipal;

    }

}
