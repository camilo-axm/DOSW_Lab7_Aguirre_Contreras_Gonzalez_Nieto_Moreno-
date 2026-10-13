package edu.eci.dosw.oficioya.model;

import java.time.LocalDateTime;
import java.util.Set;

public class UserModel {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String photoUrl;
    private String fcmToken;
    private String phone;
    private String status;
    private LocalDateTime createdAt;
    private Set<String> roles;
    private WorkModel work;
    private ContractorModel contractor;

    public UserModel() {
    }

    public UserModel(Integer id, String name, String email, String password, String photoUrl, String fcmToken,
                String phone, String status,
                LocalDateTime createdAt, Set<String> roles, WorkModel work, ContractorModel contractor) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.photoUrl = photoUrl;
        this.fcmToken = fcmToken;
        this.phone = phone;
        this.status = status;
        this.createdAt = createdAt;
        this.roles = roles;
        this.work = work;
        this.contractor = contractor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public WorkModel getWork() {
        return work;
    }

    public void setWork(WorkModel work) {
        this.work = work;
    }

    public ContractorModel getContractor() {
        return contractor;
    }

    public void setContractor(ContractorModel contractor) {
        this.contractor = contractor;
    }
}
