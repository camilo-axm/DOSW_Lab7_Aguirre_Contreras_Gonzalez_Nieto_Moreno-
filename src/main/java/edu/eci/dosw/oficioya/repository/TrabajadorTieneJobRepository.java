package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Trabajador_tiene_job;
import edu.eci.dosw.oficioya.entity.Trabajador_tiene_job_id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrabajadorTieneJobRepository
        extends JpaRepository<Trabajador_tiene_job, Trabajador_tiene_job_id> {

    List<Trabajador_tiene_job> findByTrabajador_IdUsuario(Long idTrabajador);

    List<Trabajador_tiene_job> findByJob_IdJob(Long idJob);

    Optional<Trabajador_tiene_job> findByTrabajador_IdUsuarioAndEsPrincipalTrue(Long idTrabajador);

    boolean existsByTrabajador_IdUsuarioAndEsPrincipalTrue(Long idTrabajador);
}