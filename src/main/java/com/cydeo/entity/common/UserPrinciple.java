package com.cydeo.entity.common;

import com.cydeo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrinciple implements UserDetails {

    private  User user;

    public UserPrinciple(User user) {//
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList=new ArrayList<>();
        GrantedAuthority authority=new SimpleGrantedAuthority(this.user.getRole().getDescription());
        authorityList.add(authority);
        return authorityList;
    }

    @Override
    public String getPassword() {//get the password from databsae set it to Spring security//actually we are mapping
       // How Im gonna set it?How i can access to password field of the user

        return this.user.getPassWord();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
