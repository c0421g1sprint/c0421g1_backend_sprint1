//package com.codegym.entity.about_account;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
////Kiet login 23/10 USerDetailsService loadByUsername will return this class
//public class AccountDetails implements UserDetails {
//
//    private final Account account;
//
//    public AccountDetails(Account account) {
//        this.account = account;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> roles= new ArrayList<>();
//        for (Role items: this.account.getRoles())
//            roles.add(new SimpleGrantedAuthority(items.getRoleName()));
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.account.getAccountPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return this.account.getAccountUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.account.isLock_flag();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.account.isActivated_flag();
//    }
//}
