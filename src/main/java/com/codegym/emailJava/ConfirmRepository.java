package com.codegym.emailJava;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmRepository extends JpaRepository<VerifyEmail, Long> {
    Optional<VerifyEmail> findByToken(String token);
}
