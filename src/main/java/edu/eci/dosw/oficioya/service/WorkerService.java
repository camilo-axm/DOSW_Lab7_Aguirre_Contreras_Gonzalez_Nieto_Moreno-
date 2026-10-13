package edu.eci.dosw.oficioya.service;

import edu.eci.dosw.oficioya.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import edu.eci.dosw.oficioya.mapper.UsuarioMapper;
import edu.eci.dosw.oficioya.repository.TrabajadorRepository;
import edu.eci.dosw.oficioya.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import edu.eci.dosw.oficioya.entity.Usuario;
import edu.eci.dosw.oficioya.model.WorkModel;
import java.math.BigDecimal;
import edu.eci.dosw.oficioya.entity.Trabajador;
import edu.eci.dosw.oficioya.entity.Trabajador_tiene_job;

@Service
public class WorkerService {

    private static final Logger log = LoggerFactory.getLogger(WorkerService.class);

    private final UsuarioRepository usuarioRepository;
    private final TrabajadorRepository trabajadorRepository;
    private final UsuarioMapper usuarioMapper;

    public WorkerService(UsuarioRepository usuarioRepository,TrabajadorRepository trabajadorRepository, UsuarioMapper usuarioMapper) {
        
        this.usuarioRepository = usuarioRepository;
        this.trabajadorRepository = trabajadorRepository;
        this.usuarioMapper = usuarioMapper;
    
    }

    @Transactional(readOnly = true)
    public List<UserModel> findAll() {
        log.debug("Consultando todos los trabajadores en la base de datos");
        return trabajadorRepository.findAll().stream()
                .map(t -> usuarioMapper.toModel(t.getUsuario()))
                .toList();
    }

    @Transactional(readOnly = true)
    public Optional<UserModel> findById(Integer id) {
        log.debug("Buscando trabajador con id: {}", id);
        Optional<UserModel> result = trabajadorRepository.findById(id.longValue())
                .map(t -> usuarioMapper.toModel(t.getUsuario()));

        if (result.isPresent()) {
            log.info("Trabajador encontrado con id: {}", id);
        } else {
            log.warn("No se encontró trabajador con id: {}", id);
        }
        return result;
    }

    @Transactional
    public UserModel create(UserModel user) {
        user.setId(null);
        user.setStatus("ACTIVO");
        if (user.getWork() == null) {
            user.setWork(new WorkModel());
        }
        user.getWork().setId(null);
        if (user.getWork().getApproxRate() == null) {
            user.getWork().setApproxRate(BigDecimal.ZERO);
        }
        if (user.getContractor() != null) {
            user.getContractor().setId(null);
        }
        Usuario saved = usuarioRepository.save(usuarioMapper.toEntity(user));
        log.info("Trabajador creado con id: {} y correo: {}", saved.getId(), saved.getEmail());
        return usuarioMapper.toModel(saved);
    }

    @Transactional
public Optional<UserModel> update(Integer id, UserModel updatedUser) {
    log.debug("Intentando actualizar trabajador con id: {}", id);

    Optional<Trabajador> currentOpt = trabajadorRepository.findById(id.longValue());
    if (currentOpt.isEmpty()) {
        log.warn("No se pudo actualizar: trabajador con id {} no existe", id);
        return Optional.empty();
    }

    Trabajador trabajador = currentOpt.get();
    Usuario current = trabajador.getUsuario();
    if ("INACTIVO".equals(current.getStatus())) {
        log.warn("No se pudo actualizar: trabajador con id {} está INACTIVO", id);
        return Optional.empty();
    }

    Usuario incoming = usuarioMapper.toEntity(updatedUser);
    current.setEmail(incoming.getEmail());
    current.setPhone(incoming.getPhone());
    current.setFullName(incoming.getFullName());
    current.setPassword(incoming.getPassword());
    current.setPhotoUrl(incoming.getPhotoUrl());
    current.setFcmToken(incoming.getFcmToken());
    if (incoming.getRoles() != null) {
        current.setRoles(incoming.getRoles());
    }

    Trabajador datos = incoming.getTrabajador();
    if (datos != null) {
        if (datos.getPriceRate() != null) {
            trabajador.setPriceRate(datos.getPriceRate());
        }
        trabajador.setStatusAvailable(datos.getStatusAvailable());
        trabajador.setPromedioReputacion(datos.getPromedioReputacion());
        trabajador.setTotalTrabajos(datos.getTotalTrabajos());

        trabajador.getJobs().clear();
        trabajadorRepository.flush();
        for (Trabajador_tiene_job tj : datos.getJobs()) {
            trabajador.agregarJob(tj.getJob(), tj.getEsPrincipal());
        }
    }

    log.info("Trabajador actualizado con id: {}", id);
    return Optional.of(usuarioMapper.toModel(usuarioRepository.save(current)));
}

    @Transactional
    public Optional<UserModel> inactivate(Integer id) {
        log.debug("Intentando inactivar trabajador con id: {}", id);
        Optional<UserModel> result = trabajadorRepository.findById(id.longValue())
                .map(t -> {
                    Usuario usuario = t.getUsuario();
                    usuario.setStatus("INACTIVO");
                    return usuarioMapper.toModel(usuarioRepository.save(usuario));
                });

        if (result.isPresent()) {
            log.info("Trabajador inactivado con id: {}", id);
        } else {
            log.warn("No se pudo inactivar: trabajador con id {} no existe", id);
        }
        return result;
    }
}