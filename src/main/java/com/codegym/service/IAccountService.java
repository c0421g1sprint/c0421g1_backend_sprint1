package com.codegym.service;

import com.codegym.entity.about_account.Account;

public interface IAccountService {
    //    Kiet login comment 31/10
    Account findByUsername(String username);

    //    Kiet login comment 31/10
    void signUp(Account account);

    //    Kiet login comment 31/10
    Account findAccountByEmail(String email);

    //HauPT do editPassword function
    void editPassword(Integer id , String password );

    //HauPT do getAccountById function
    Account getAccountById(int id);

}
