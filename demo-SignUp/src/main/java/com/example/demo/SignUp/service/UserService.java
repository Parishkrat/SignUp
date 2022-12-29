package com.example.demo.SignUp.service;

import com.example.demo.SignUp.model.UserDtls;

public interface UserService {
    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);
}
