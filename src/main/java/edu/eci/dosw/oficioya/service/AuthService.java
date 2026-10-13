package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.model.UserModel;
import edu.eci.dosw.oficioya.mapper.UsuarioMapper;
import edu.eci.dosw.oficioya.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public AuthService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Transactional(readOnly = true)
    public Optional<UserModel> authenticate(String email, String password) {
        log.debug("Intentando autenticar usuario con correo: {}", email);

        Optional<UserModel> result = usuarioRepository.findByEmail(email)
                .filter(u -> u.getPassword() != null && u.getPassword().equals(password))
                .map(usuarioMapper::toModel);

        if (result.isPresent()) {
            log.info("Autenticación exitosa para correo: {}", email);
        } else {
            log.warn("Autenticación fallida para correo: {}", email);
        }
        return result;
    }
}