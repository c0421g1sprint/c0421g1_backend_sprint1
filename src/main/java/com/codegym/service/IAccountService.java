package com.codegym.service;

import com.codegym.entity.about_account.Account;

public interface IAccountService {

    //HauPT do editPassword function
    void editPassword(Integer id , String password );

    //HauPT do getAccountById function
    Account getAccountById(int id);
}
