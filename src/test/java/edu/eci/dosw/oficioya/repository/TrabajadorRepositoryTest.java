package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Job;
import edu.eci.dosw.oficioya.entity.Trabajador;
import edu.eci.dosw.oficioya.entity.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class TrabajadorRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TrabajadorTieneJobRepository trabajadorTieneJobRepository;

    @Autowired
    private EntityManager entityManager;

    private Trabajador crearTrabajador(String email, Long phone, String nombre, boolean disponible) {
        Usuario usuario = new Usuario(email, phone, nombre, "1234");
        Trabajador trabajador = new Trabajador();
        trabajador.setPriceRate(new BigDecimal("50000"));
        trabajador.setStatusAvailable(disponible);
        usuario.setTrabajador(trabajador);
        usuarioRepository.save(usuario);
        return trabajador;
    }

    @Test
    @DisplayName("Debe guardar un trabajador asociado a su usuario")
    void shouldSaveTrabajadorWithUsuario() {
        Trabajador trabajador = crearTrabajador("t1@ejemplo.com", 3101111111L, "Pedro Gomez", true);
        entityManager.flush();
        entityManager.clear();

        Trabajador leido = trabajadorRepository.findById(trabajador.getId()).orElseThrow();
        assertEquals("t1@ejemplo.com", leido.getUsuario().getEmail());
        assertEquals(leido.getId(), leido.getUsuario().getId());
    }

    @Test
    @DisplayName("Debe consultar trabajadores por nombre y disponibilidad")
    void shouldFindTrabajadores() {
        crearTrabajador("t2@ejemplo.com", 3102222222L, "Maria Lopez", true);
        crearTrabajador("t3@ejemplo.com", 3103333333L, "Mario Ruiz", false);
        entityManager.flush();

        assertEquals(2, trabajadorRepository.findByUsuarioFullNameContainingIgnoreCase("mar").size());
        assertEquals(1, trabajadorRepository.findByStatusAvailableTrue().size());
    }

    @Test
    @DisplayName("Debe relacionar un trabajador con sus oficios")
    void shouldRelateTrabajadorWithJobs() {
        Trabajador trabajador = crearTrabajador("t4@ejemplo.com", 3104444444L, "Carlos Diaz", true);
        Job plomeria = jobRepository.save(new Job("Plomeria", true));
        Job electricidad = jobRepository.save(new Job("Electricidad", true));

        trabajador.agregarJob(plomeria, true);
        trabajador.agregarJob(electricidad, false);
        entityManager.flush();
        entityManager.clear();

        assertEquals(2, trabajadorTieneJobRepository.findByTrabajador_Id(trabajador.getId()).size());
        assertTrue(trabajadorTieneJobRepository.existsByTrabajador_IdAndEsPrincipalTrue(trabajador.getId()));
        assertEquals(1, trabajadorTieneJobRepository.findByJob_Id(plomeria.getId()).size());
    }
}