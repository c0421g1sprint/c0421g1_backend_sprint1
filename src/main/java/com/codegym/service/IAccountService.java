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

    //Duc
    void saveAccount(String accountUsername, String accountPassword,String email);
    //Duc
    void updateIdAccountTeacher(Integer accountId,Integer teacherId);

    Integer maxIdAccount();
    //Duc
    String checkUsername(String userName);
}
