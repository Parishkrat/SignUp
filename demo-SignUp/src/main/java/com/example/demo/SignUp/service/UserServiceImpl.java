package com.example.demo.SignUp.service;

import com.example.demo.SignUp.model.UserDtls;
import com.example.demo.SignUp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired //automatically create object
    private UserRepository userRepo; // to save data we need repo

    @Override
    public UserDtls createUser(UserDtls user) {
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
