package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class QuanLiTruongTieuHocApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanLiTruongTieuHocApplication.class, args);
//        System.out.println(new BCryptPasswordEncoder().encode("123456789"));

    }

}
