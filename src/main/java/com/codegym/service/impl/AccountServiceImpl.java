package com.codegym.service.impl;

import com.codegym.entity.about_account.Account;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveAccount(String accountUsername, String accountPassword) {
        String passwordEncode = passwordEncoder.encode(accountPassword);
        accountRepository.saveQuery(accountUsername, passwordEncode);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findByIdQuery(id);
    }
}
