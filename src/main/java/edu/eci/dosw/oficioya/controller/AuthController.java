package edu.eci.dosw.oficioya.controller;

import edu.eci.dosw.oficioya.dto.LoginRequest;
import edu.eci.dosw.oficioya.model.UserModel;
import edu.eci.dosw.oficioya.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Operaciones de autenticación por medio del login")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Autenticar usuario por medio de correo y contraseña")
    public ResponseEntity<UserModel> login(@RequestBody LoginRequest request) {
        return authService.authenticate(request.getEmail(), request.getPassword())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}