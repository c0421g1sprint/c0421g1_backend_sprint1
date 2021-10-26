package com.codegym.service;

import com.codegym.entity.about_account.Account;

public interface IAccountService {
    void editPassword(Integer id , String password );
    Account getAccountById(int id);
}
