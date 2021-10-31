package com.codegym.service;

import com.codegym.entity.about_account.Account;

public interface IAccountService {
    Account findByUsername(String username);
    void signUp(Account account);
    Account findAccountByEmail(String email);

    //HauPT do editPassword function
    void editPassword(Integer id , String password );

    //HauPT do getAccountById function
    Account getAccountById(int id);

}
