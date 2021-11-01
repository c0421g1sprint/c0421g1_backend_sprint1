package com.codegym.rest_controller;


import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_account.AccountDto;
import com.codegym.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping(value = "/detailAccount/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Account account = this.accountService.findById(id).orElse(null);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<List<FieldError>> createAccount(@Valid @RequestBody AccountDto accountDto,
                                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        this.accountService.saveAccount(accountDto.getAccountUsername(),accountDto.getAccountPassword());
        this.accountService.updateIdAccountTeacher(accountDto.getTeacherId(),accountDto.getAccountId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

