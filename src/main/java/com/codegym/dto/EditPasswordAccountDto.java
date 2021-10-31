package com.codegym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditPasswordAccountDto {
    private Integer accountId;
    @NotNull
    @NotEmpty
    @Size(min = 4 , max = 30 )
    @Pattern(regexp = "^[0-9a-zA-Z]+$")
    private String accountPassword;
    private String oldPassword;
    private String confirmPassword;

}

