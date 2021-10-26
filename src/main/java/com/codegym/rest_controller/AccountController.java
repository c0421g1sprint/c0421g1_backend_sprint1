package com.codegym.rest_controller;

import com.codegym.dto.EditPasswordAccountDto;
import com.codegym.entity.about_account.Account;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    //HauPT do editPassword function
    @PatchMapping("/editPass")
    public ResponseEntity<?> editPassword (@RequestBody @Validated EditPasswordAccountDto editPasswordAccountDto , BindingResult bindingResult) {
        Account account = accountService.getAccountById(editPasswordAccountDto.getAccountId());
        if (!account.getAccountPassword().equals(editPasswordAccountDto.getOldPassword()) || bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            accountService.editPassword(editPasswordAccountDto.getAccountId(), editPasswordAccountDto.getAccountPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
