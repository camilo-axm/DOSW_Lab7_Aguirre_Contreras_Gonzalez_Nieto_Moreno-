package edu.eci.dosw.oficioya.repository;

import edu.eci.dosw.oficioya.entity.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager entityManager;

    private Usuario nuevoUsuario(String email, Long phone) {
        return new Usuario(email, phone, "Juan Perez", "1234");
    }

    @Test
    @DisplayName("Debe guardar un usuario y generar su id")
    void shouldSaveUsuario() {
        Usuario guardado = usuarioRepository.save(nuevoUsuario("juan@ejemplo.com", 3001234567L));

        assertNotNull(guardado.getId());
        assertEquals("juan@ejemplo.com", guardado.getEmail());
        assertNotNull(guardado.getCreatedAt());
    }

    @Test
    @DisplayName("Debe consultar un usuario por correo y teléfono")
    void shouldFindByEmail() {
        usuarioRepository.save(nuevoUsuario("ana@ejemplo.com", 3002223344L));

        assertTrue(usuarioRepository.findByEmail("ana@ejemplo.com").isPresent());
        assertTrue(usuarioRepository.existsByEmail("ana@ejemplo.com"));
        assertTrue(usuarioRepository.existsByPhone(3002223344L));
        assertFalse(usuarioRepository.existsByPhone(3009999999L));
    }

    @Test
    @DisplayName("Debe actualizar un usuario")
    void shouldUpdateUsuario() {
        Usuario guardado = usuarioRepository.save(nuevoUsuario("luis@ejemplo.com", 3003334455L));
        guardado.setFullName("Luis Editado");
        entityManager.flush();
        entityManager.clear();

        Usuario leido = usuarioRepository.findById(guardado.getId()).orElseThrow();
        assertEquals("Luis Editado", leido.getFullName());
    }

    @Test
    @DisplayName("Debe eliminar un usuario")
    void shouldDeleteUsuario() {
        Usuario guardado = usuarioRepository.save(nuevoUsuario("eli@ejemplo.com", 3004445566L));
        Long id = guardado.getId();

        usuarioRepository.deleteById(id);
        entityManager.flush();
        entityManager.clear();

        assertFalse(usuarioRepository.findById(id).isPresent());
    }
}