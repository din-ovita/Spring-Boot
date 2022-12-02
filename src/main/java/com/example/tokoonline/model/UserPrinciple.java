package com.example.tokoonline.model;

import com.example.tokoonline.enumated.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Collections;

//membuat cetakan data, turunan userdetails,
public class UserPrinciple implements UserDetails {

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Collection<? extends GrantedAuthority> authority;

    public UserPrinciple(String username, String password, Collection<? extends GrantedAuthority> authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

//    fungsi static : bisa dipanggil di lain file, dgn name_class.name_method
    public static UserPrinciple build(User user) {
        var role = Collections.singletonList(new SimpleGrantedAuthority(user.getUserType().name()));
        return new UserPrinciple(
                user.getUsername(),
                user.getPassword(),
                role
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() { // akun tidak kadarluarsa
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // akun tidak dikunci
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // akses tidak terbatas
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
