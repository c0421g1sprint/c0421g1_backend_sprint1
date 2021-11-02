package com.codegym.service.impl;
import com.codegym.entity.about_account.Account;
import com.codegym.entity.about_account.AccountDetails;
import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IAccountService accountService;
//    Kiet login 23/10 AuthenticationManager user this function
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountService.findByUsername(username);
        if (account ==  null){
            throw  new UsernameNotFoundException("Can not find this username");
        }
        return new AccountDetails(account);
    }
}
