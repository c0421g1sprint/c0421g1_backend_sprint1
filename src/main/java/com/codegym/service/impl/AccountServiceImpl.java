//package com.codegym.service.impl;
//
//import com.codegym.emailJava.ConfirmService;
//import com.codegym.emailJava.VerifyEmail;
//import com.codegym.emailJava.email.EmailSender;
//import com.codegym.entity.about_account.Account;
//import com.codegym.repository.IAccountRepository;
//import com.codegym.service.IAccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Service
//public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    private IAccountRepository accountRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private ConfirmService confirmService;
//
//    @Autowired
//    private EmailSender emailSender;
//
//    //    Kiet login 23/10 UserDetailService use this function
//    @Override
//    public Account findByUsername(String username) {
//        return this.accountRepository.findAccountByUsername(username);
//    }
//
//    //    Kiet login 26/10 Register account and send Email to verify
//    @Transactional
//    public void signUp(Account account){
//        Account registerAccount = this.accountRepository.findAccountByUsername(account.getAccountUsername());
//        if (registerAccount != null){
//            throw new IllegalStateException("email haved already exist");
//        }
//        String encode = passwordEncoder.encode(account.getAccountPassword());
//        account.setAccountPassword(encode);
//        this.accountRepository.signUpAccount(account.getAccountUsername(), account.getAccountPassword(), account.getEmail() );
//        registerAccount = this.accountRepository.findAccountByUsername(account.getAccountUsername());
//        this.accountRepository.setRoleForUser(registerAccount.getAccountId());
//        String token = UUID.randomUUID().toString();
//        VerifyEmail verifyEmail = new VerifyEmail(
//                token, registerAccount.getEmail(),
//                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15));
//        this.confirmService.saveTokenSendByEmail(verifyEmail);
//        String link = "http://localhost:8080/api/public/confirm?token=" + token;
//        String contentEmail = emailSender.buildEmail(link);
//        emailSender.send(registerAccount.getEmail(), contentEmail);
//    }
//
//    //HauPT do editPassword function
//    @Override
//    public void editPassword(Integer id , String password ) {
//       accountRepository.editPassword(id, password);
//    }
//
//    //HauPT do getAccountById function
//    @Override
//    public Account getAccountById(int id) {
//        return accountRepository.getAccountById(id);
//    }
//
//}
