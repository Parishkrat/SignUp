package com.example.demo.SignUp.repository;

import com.example.demo.SignUp.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDtls,Integer> {
    public Boolean existsByEmail(String email);
}
