package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @NotNull
    @Column(nullable = false, unique = true)
    private Long phone;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Column(name = "full_name", nullable = false, length = 50)
    private String full_name;

    @NotBlank
    @Size(max = 12)
    @Column(nullable = false, length = 12)
    private String password;

    public Usuario() {
    }

    public Usuario(String email, Long phone, String username, String full_name, String password) {
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.full_name = full_name;
        this.password = password;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}