package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class AccountDto {
    @NotBlank
    @NotNull
    private String accountUsername;
    @NotBlank
    @NotNull
    private String accountPassword;
    @Pattern(regexp = "^[a-zA-Z0-9]+\\@[a-z]+\\.[a-z]+$")
    private String email;
    private static final boolean IS_ACTIVE = false;
    private static final boolean IS_NOT_LOCK = true;
    private static final boolean IS_DELETE = false;

}
