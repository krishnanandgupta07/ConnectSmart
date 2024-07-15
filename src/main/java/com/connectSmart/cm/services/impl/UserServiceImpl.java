package com.connectSmart.cm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.connectSmart.cm.entity.User;
import com.connectSmart.cm.helper.AppConstants;
import com.connectSmart.cm.helper.ResourceNotFoundException;
import com.connectSmart.cm.repository.UserRepo;
import com.connectSmart.cm.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //user id have to generate
        String userId=UUID.randomUUID().toString();
        user.setUserId(userId);
        //password encoder
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //set the user role
        user.setRoleList(List.of(AppConstants.ROLE_USER));

       // user.setPassword(userId);
       User savedUser= userRepo.save(user);
        return savedUser;
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2=userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User not found"));
        //update user2
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        // save the user in database
        User save=userRepo.save(user2);
        return Optional.ofNullable(save);


    }

    @Override
    public void deleteUser(String id) {
        User user3=userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
        userRepo.delete(user3);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user4= userRepo.findById(userId).orElse(null);
        return user4 !=null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user4= userRepo.findByEmail(email).orElse(null);
        return user4 !=null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
       return userRepo.findByEmail(email).orElse(null);
    }


}
