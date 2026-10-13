package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

    Optional<Trabajador> findByUsername(String username);

    List<Trabajador> findByFullNameContainingIgnoreCase(String fullName);

    List<Trabajador> findByStatusAvailableTrue();

    List<Trabajador> findByStatusAvailableTrueAndEsPausadoFalse();

    List<Trabajador> findByEsPausadoFalseAndPromedioReputacionGreaterThanEqualOrderByPromedioReputacionDesc(
            Double promedioMinimo);

    List<Trabajador> findByPriceRateLessThanEqual(java.math.BigDecimal tarifaMaxima);
}