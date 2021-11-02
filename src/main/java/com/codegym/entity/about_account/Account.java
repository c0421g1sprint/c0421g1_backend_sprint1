package com.codegym.entity.about_account;
import com.codegym.entity.about_teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public  class  Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String accountUsername;
    private String accountPassword;
    private String email;
    private boolean isActive;
    private boolean isNotBlock;
    private boolean isDelete;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @JsonBackReference(value = "teacher_account")
    @OneToOne(mappedBy = "account")
    private Teacher teacher;

}
