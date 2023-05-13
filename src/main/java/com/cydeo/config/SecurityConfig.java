package com.cydeo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {
  //if  you are only creating a bean means just give an object=>you can include this one inside running class
    //but if you are writing bigger concept//you can write separate configuration class
    //I want do myUserDTO
  //Spring wants to use its own classes
    @Bean
    public UserDetailsService userDetailService(PasswordEncoder encoder){
      //this is interface//service and UserDetail and User class
   //   UserDetails user1=new User(); //its spring user class//I want more than one
      List<UserDetails> userList=new ArrayList<>();//now we will learn manually
      //import spring security //not entity// and define constructor
      userList.add( new User("mike",encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
      userList.add( new User("ozzy",encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER"))));
return new InMemoryUserDetailsManager(userList);

    }


}
