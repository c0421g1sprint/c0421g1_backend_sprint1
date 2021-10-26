package com.codegym.service;

import com.codegym.entity.about_account.Account;

import java.util.Optional;

public interface IAccountService {
    void saveAccount(String accountUsername, String accountPassword);
    Optional<Account> findById(Long id);
    void updateIdAccountTeacher(Integer teacherId,Integer accountId);
    void findByIdQuery(Long id);
}
