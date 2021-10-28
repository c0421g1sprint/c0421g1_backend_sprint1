package com.codegym.rest_controller;

import com.codegym.dto.AccountDto;
import com.codegym.dto.EditPasswordAccountDto;
import com.codegym.dto.LoginRequestDto;
import com.codegym.emailJava.ConfirmService;
import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_account.AccountDetails;
import com.codegym.jwtToken.JwtProvider;
import com.codegym.jwtToken.ResponseToken;
import com.codegym.service.IAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/public")
public class AccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider tokenProvider;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/info")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }

    //    Kiet login API use to authentication by HttpBasic 23/10
    @PostMapping("/login")
    public ResponseEntity<?> loginAccount(@Valid @RequestBody LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails user = userDetailsService.loadUserByUsername(loginRequestDto.getUsername());
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority items : user.getAuthorities()) {
            roles.add(items.getAuthority());
        }
        String token = tokenProvider.generateToken(user);
        return new ResponseEntity<>(new ResponseToken(token, user.getUsername(), roles), HttpStatus.OK);
    }

//    Kiet login API use to refreshToken 23/10
    @GetMapping("/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorization != null && authorization.startsWith("KIET ")) {
            try {
                authorization = authorization.substring(5);
                String username = tokenProvider.getUsernameFromToken(authorization);
                AccountDetails account = (AccountDetails) userDetailsService.loadUserByUsername(username);
                String token = tokenProvider.generateToken(account);
                Map<String, String> tokenResponse = new HashMap<>();
                tokenResponse.put("refreshToken", token);
                new ObjectMapper().writeValue(response.getOutputStream(), tokenResponse);
            } catch (Exception ex) {
                System.out.println("Message log{}" + ex.getMessage());
            }
        }
    }

//    Kiet login register account 26/10
    @GetMapping("/register")
    public ResponseEntity<?> sendLinkRegisterByEmail(@Valid @RequestBody AccountDto accountDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Account account = new Account();
            BeanUtils.copyProperties(accountDto, account);
            this.accountService.signUp(account);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestParam(value = "token") String token) {
        try {
            confirmService.confirmEmailWithToken(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Chức mừng bạn đã kích hoạt tài khoản", HttpStatus.OK);
    }

    //HauPT do editPassword function
    @PatchMapping(value = "/editPass", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> editPassword (@RequestBody @Valid EditPasswordAccountDto editPasswordAccountDto , BindingResult bindingResult) {
        System.out.println(editPasswordAccountDto);
        Integer id = editPasswordAccountDto.getAccountId();
        Account account = accountService.getAccountById(id);
//        BCrypt.checkpw(account.getAccountPassword(),editPasswordAccountDto.getOldPassword());
        if (!account.getAccountPassword().equals(editPasswordAccountDto.getOldPassword())
                || bindingResult.hasFieldErrors()
                || !editPasswordAccountDto.getAccountPassword().equals(editPasswordAccountDto.getConfirmPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            accountService.editPassword(editPasswordAccountDto.getAccountId(), editPasswordAccountDto.getAccountPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

