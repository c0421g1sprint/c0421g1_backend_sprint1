package com.codegym.rest_controller;

import com.codegym.dto.AccountDto;
import com.codegym.dto.EditPasswordAccountDto;
import com.codegym.dto.LoginRequestDto;
import com.codegym.email_java.ConfirmService;
import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_account.AccountDetails;
import com.codegym.jwt_token.JwtProvider;
import com.codegym.jwt_token.ResponseToken;
import com.codegym.service.IAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/info")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }

    //    Kiet login API use to authentication by HttpBasic 23/10
    @PostMapping("/login")
    public ResponseEntity<ResponseToken> loginAccount(@Valid @RequestBody LoginRequestDto loginRequestDto, BindingResult bindingResult) {
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
                LOGGER.error(ex.getMessage());
            }
        }
    }

//    Kiet login register account 26/10
    @GetMapping("/register")
    public ResponseEntity<String> sendLinkRegisterByEmail(@Valid @RequestBody AccountDto accountDto, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Account account = new Account();
            BeanUtils.copyProperties(accountDto, account);
            this.accountService.signUp(account);
        }catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage() ,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm(@RequestParam(value = "token") String token) {
        try {
            confirmService.confirmEmailWithToken(token);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Chức mừng bạn đã kích hoạt tài khoản", HttpStatus.OK);
    }

    //HauPT do editPassword function
    @PatchMapping("/editPass")
    public ResponseEntity<String> editPassword (@RequestBody @Valid EditPasswordAccountDto editPasswordAccountDto , BindingResult bindingResult) {
        Account account = accountService.getAccountById(editPasswordAccountDto.getAccountId());
        if (!passwordEncoder.matches(editPasswordAccountDto.getOldPassword(), account.getAccountPassword()) || bindingResult.hasFieldErrors())  {
            System.out.println("123");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            accountService.editPassword(editPasswordAccountDto.getAccountId(), editPasswordAccountDto.getAccountPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

