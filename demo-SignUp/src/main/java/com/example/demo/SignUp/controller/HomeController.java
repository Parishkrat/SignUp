package com.example.demo.SignUp.controller;
import com.example.demo.SignUp.model.UserDtls;
import com.example.demo.SignUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }


    @GetMapping("/SignUp")
    public String SignUp() {
        return "SignUp";
    }

    @PostMapping("/createUser")
    public String create_user(@ModelAttribute UserDtls user, HttpSession session) {
//        System.out.println(user);
        boolean check = userService.checkEmail(user.getEmail());

        if (check) {
            session.setAttribute("msg","Email Id Already Exits");
        } else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg","Register Successful");
            } else {
                session.setAttribute("msg","Error");
            }
        }
            return "redirect:/SignUp";
        }

}