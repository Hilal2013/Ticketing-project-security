package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TicketingProjectSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectSecurityApplication.class, args);
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
@Bean
    public PasswordEncoder passwordEncoder(){//this is interface we need one implementation
        return new BCryptPasswordEncoder();//it is taking your password and then putting certain logic
    // and changing encoded structure
}


}
