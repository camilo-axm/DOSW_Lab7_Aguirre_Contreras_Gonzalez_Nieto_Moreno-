package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {

    List<Trabajador> findByUsuarioFullNameContainingIgnoreCase(String fullName);

    List<Trabajador> findByStatusAvailableTrue();

    List<Trabajador> findByStatusAvailableTrueAndStatus(String status);

    List<Trabajador> findByStatusAndPromedioReputacionGreaterThanEqualOrderByPromedioReputacionDesc(String status, Double promedioMinimo);

    List<Trabajador> findByPriceRateLessThanEqual(java.math.BigDecimal priceRate);
}