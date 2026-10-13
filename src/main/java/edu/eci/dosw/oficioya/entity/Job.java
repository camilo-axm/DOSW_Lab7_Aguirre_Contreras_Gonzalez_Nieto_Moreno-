package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_job")
    private Long id;

    @NotBlank
    @Size(max = 250)
    @Column(nullable = false, unique = true, length = 250)
    private String nombre;

    @NotNull
    @Column(nullable = false)
    private Boolean activo = true;

    public Job() {
    }

    public Job(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
