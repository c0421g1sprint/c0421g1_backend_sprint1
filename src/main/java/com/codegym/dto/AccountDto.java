package com.codegym.DTO;

import com.codegym.entity.about_account.Role;
import com.codegym.entity.about_teacher.Teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Integer accountId;
    private String accountUsername;
    private String accountPassword;
    private String accountEmail;
    private boolean activated_flag;
    private boolean lock_flag;
    private boolean delete_flag;
    private Set<Role> roles;
    private Teacher teacher;
}
