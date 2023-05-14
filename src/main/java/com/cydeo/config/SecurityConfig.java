package com.cydeo.config;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {
  //if  you are only creating a bean means just give an object=>you can include this one inside running class
    //but if you are writing bigger concept//you can write separate configuration class
    //I want do myUserDTO
  //Spring wants to use its own classes
//    @Bean
//    public UserDetailsService userDetailService(PasswordEncoder encoder){
//      //this is interface//service and UserDetail and User class
//   //   UserDetails user1=new User(); //its spring user class//I want more than one
//      List<UserDetails> userList=new ArrayList<>();//now we will learn manually
//      //import spring security //not entity// and define constructor
//      userList.add( new User("mike",encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
//      userList.add( new User("ozzy",encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER"))));
//return new InMemoryUserDetailsManager(userList);
//
//    }
    @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
return http
        .authorizeRequests()  //whenever we run our security,we need to authorize each pages//we basicly checking each request//needs handling exception
       // .antMatchers("/user/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasAuthority("ROLE_ADMIN")//in the database we have just admin
    //    .antMatchers("/project/**").hasRole("MANAGER")
     //   .antMatchers("/task/employee/**").hasRole("EMPLOYEE")
     //   .antMatchers("/task/**").hasRole("MANAGER")
        //.antMatchers("/task/**").hasAnyRole("EMPLOYEE","ADMIN")
      //  .antMatchers("/task/**").hasAuthority("ROLE_EMPLOYEE")
        .antMatchers("/",
                "/login",
                "/fragments/**",
                "/images/**").permitAll()
        .anyRequest().authenticated()//another requests needs to be authenticated
        .and()
        //.httpBasic()//that popup box//I wanna use own my login page
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/welcome")
        .failureUrl("/login?error=true")
        .permitAll()
        .and().build();

    }

}
