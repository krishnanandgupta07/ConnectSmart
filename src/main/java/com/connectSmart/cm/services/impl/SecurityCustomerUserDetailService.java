package com.connectSmart.cm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.connectSmart.cm.repository.UserRepo;

@Service
public class SecurityCustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // load your user
        return userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("user not found with this email"+username));
    }

}
