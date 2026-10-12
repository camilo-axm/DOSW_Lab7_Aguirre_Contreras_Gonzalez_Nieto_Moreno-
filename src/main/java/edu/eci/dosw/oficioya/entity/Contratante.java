package edu.eci.dosw.oficioya.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Contratantes")
@PrimaryKeyJoinColumn(name = "id_contratante")
public class Contratante extends Usuario {

    @Column(name = "profile_photo")
    private byte[] profilePhoto;

    public Contratante() {
        super();
    }

    public Contratante(String email,
            Long phone,
            String username,
            String full_name,
            String password,
            byte[] profilePhoto) {
        super(email, phone, username, full_name, password);
        this.profilePhoto = profilePhoto;
    }

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}