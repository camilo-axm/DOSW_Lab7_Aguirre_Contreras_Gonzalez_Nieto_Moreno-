package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    Optional<Job> findByNombre(String nombre);

    List<Job> findByNombreContainingIgnoreCase(String nombre);

    List<Job> findByActivoTrue();

    boolean existsByNombre(String nombre);
}
