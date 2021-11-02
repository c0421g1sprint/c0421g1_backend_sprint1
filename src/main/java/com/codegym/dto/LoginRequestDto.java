package com.codegym.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Kiet login 23/10 this class to verify requestBody from angular
public class LoginRequestDto {
    @Size(max = 30, message = "Khong qua 30 ky tu")
    @NotNull
    @NotBlank
    private String username;
    @Size(max = 30, message = "Khong qua 30 ky tu")
    @NotNull
    @NotBlank
    private String password;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
