package edu.eci.dosw.oficioya.controller;

import edu.eci.dosw.oficioya.model.UserModel;
import edu.eci.dosw.oficioya.service.WorkerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")

@Tag(name = "Trabajadores", description = "Operaciones CRUD para trabajadores")

public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los trabajadores", description = "Retorna la lista completa")
    public ResponseEntity<List<UserModel>> getAll() {
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener trabajador por ID", description = "Retorna el trabajador con el id especificado")
    public ResponseEntity<UserModel> getById(@PathVariable Integer id) {
        return workerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo trabajador", description = "Registra un trabajador nuevo como Activo")
    public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workerService.create(user));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar trabajador por ID", description = "Modifica datos si no está inactivo")
    public ResponseEntity<UserModel> update(@PathVariable Integer id, @RequestBody UserModel user) {
        return workerService.update(id, user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PatchMapping("/{id}/inactivar")
    @Operation(summary = "Inactivar trabajador por ID", description = "Cambia estado a inactivo")
    public ResponseEntity<UserModel> inactivate(@PathVariable Integer id) {
        return workerService.inactivate(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}