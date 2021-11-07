package com.codegym.service.impl;

import com.codegym.email_java.ConfirmService;
import com.codegym.email_java.VerifyEmail;
import com.codegym.email_java.email.EmailSender;
import com.codegym.entity.about_account.Account;
import com.codegym.repository.IAccountRepository;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmService confirmService;

    @Autowired
    private EmailSender emailSender;

    //    Kiet login 23/10 UserDetailService use this function
    @Override
    public Account findByUsername(String username) {
        return this.accountRepository.findAccountByUsername(username);
    }

    //    Kiet login 26/10 Register account and send Email to verify
    @Transactional
    public void signUp(Account account){
        Account registerAccount = this.accountRepository.findAccountByUsername(account.getAccountUsername());
        if (registerAccount != null){
            throw new IllegalStateException("username haved already exist");
        }
        registerAccount = this.accountRepository.findAccountByEmail(account.getEmail());
        if (registerAccount != null){
            throw new IllegalStateException("email haved already exist");
        }
        String encode = passwordEncoder.encode(account.getAccountPassword());
        account.setAccountPassword(encode);
        this.accountRepository.signUpAccount(account.getAccountUsername(), account.getAccountPassword(), account.getEmail() );
        registerAccount = this.accountRepository.findAccountByUsername(account.getAccountUsername());
        this.accountRepository.setRoleForUser(registerAccount.getAccountId());
        String token = UUID.randomUUID().toString();
        VerifyEmail verifyEmail = new VerifyEmail(
                token, registerAccount.getEmail(),
                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15));
        this.confirmService.saveTokenSendByEmail(verifyEmail);
        String link = "http://localhost:8080/api/public/confirm?token=" + token;
        String contentEmail = emailSender.buildRegisterEmail(link);
        emailSender.send(registerAccount.getEmail(), contentEmail);
    }

//    Kiet 31/10 findAccount By email
    @Override
    public Account findAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }

    //HauPT do editPassword function
    @Override
    public void editPassword(Integer id , String password ) {
        password = passwordEncoder.encode(password);
       accountRepository.editPassword(id, password);
    }

    //HauPT do getAccountById function
    @Override
    public Account getAccountById(int id) {
        return accountRepository.getAccountById(id);
    }

    //Duc do saveAccount function
    @Override
    public void saveAccount(String accountUsername, String accountPassword,String email) {
        String passwordEncode = passwordEncoder.encode(accountPassword);
        accountRepository.saveQuery(accountUsername, passwordEncode,email);
    }
    //Duc do updateIdAccountTeacher function
    @Override
    public void updateIdAccountTeacher(Integer accountId,Integer teacherId) {
        this.accountRepository.updateIdAccountTeacher(accountId,teacherId);
    }

    @Override
    public Integer maxIdAccount() {
        return this.accountRepository.maxIdAccount();
    }

    //Duc do checkUsername function
    @Override
    public String checkUsername(String userName) {
        return accountRepository.checkUsername(userName);
    }

}
