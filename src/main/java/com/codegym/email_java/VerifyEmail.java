package com.codegym.email_java;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerifyEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable =  false)
    private String token;
    @Column(nullable =  false)
    private String email;
    @Column(nullable =  false)
    private LocalDateTime createAt;
    @Column(nullable =  false)
    private LocalDateTime expireAt;
    private LocalDateTime confirmAt;

    public VerifyEmail() {
    }

    public VerifyEmail(String token, String email, LocalDateTime createAt, LocalDateTime expireAt) {
        this.token = token;
        this.email = email;
        this.createAt = createAt;
        this.expireAt = expireAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getConfirmAt() {
        return confirmAt;
    }

    public void setConfirmAt(LocalDateTime confirmAt) {
        this.confirmAt = confirmAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }
}
