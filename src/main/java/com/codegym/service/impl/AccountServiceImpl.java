package com.codegym.service.impl;

import com.codegym.entity.about_account.Account;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public void editPassword(Integer id , String password ) {
       accountRepository.editPassword(id, password);
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.getAccountById(id);
    }
}
