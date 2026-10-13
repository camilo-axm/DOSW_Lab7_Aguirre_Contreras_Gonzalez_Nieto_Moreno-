package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Trabajador_tiene_job;
import edu.eci.dosw.oficioya.entity.Trabajador_tiene_job_id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrabajadorTieneJobRepository
        extends JpaRepository<Trabajador_tiene_job, Trabajador_tiene_job_id> {

    List<Trabajador_tiene_job> findByTrabajador_Id(Long idTrabajador);

    List<Trabajador_tiene_job> findByJob_Id(Long idJob);

    Optional<Trabajador_tiene_job> findByTrabajador_IdAndEsPrincipalTrue(Long idTrabajador);

    boolean existsByTrabajador_IdAndEsPrincipalTrue(Long idTrabajador);
}