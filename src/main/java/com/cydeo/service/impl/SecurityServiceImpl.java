package com.cydeo.service.impl;

import com.cydeo.entity.User;
import com.cydeo.entity.common.UserPrinciple;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.SecurityService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //get the user from db (this is business->go to repository) and convert to user springs understands by using UserPrincipal
User user=userRepository.findByUserNameAndIsDeleted(username,false);
//I need to authenticate this user
        if(user==null){
            throw new UsernameNotFoundException(username);
        }

        return new UserPrinciple(user);
    }
}
