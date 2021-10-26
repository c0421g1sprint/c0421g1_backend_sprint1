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
    @NotNull(message = "Mật khẩu không được phép để trống")
    @NotEmpty(message = "Mật khẩu không được phép để trống")
    @Size(min = 5 , max = 20 , message = "Mật khẩu phải từ 5-20 kí tự")
    @Pattern(regexp = "^[0-9a-zA-Z]+$" , message = "Mật khẩu chỉ được chứa chữ cái thường , chữ cái in hoa và số ")
    private String accountPassword;
    private String oldPassword;

}

