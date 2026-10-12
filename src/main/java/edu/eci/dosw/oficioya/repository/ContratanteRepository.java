package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContratanteRepository extends JpaRepository<Contratante, Long> {

    Optional<Contratante> findByUsername(String username);

    Optional<Contratante> findByEmail(String email);

    List<Contratante> findByFullNameContainingIgnoreCase(String fullName);
}