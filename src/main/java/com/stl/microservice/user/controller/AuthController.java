package com.stl.microservice.user.controller;

import com.stl.microservice.user.model.User;
import com.stl.microservice.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user/auth")
public class AuthController {
    @Autowired
    UserRepo USER_REPO;
    @GetMapping("/login")
    public String login(){
        return "Login Auth Works";
    }


    @GetMapping("/register")
    public User logIN(@RequestBody User USER){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            USER.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            USER.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));

            String ENCODE_PASSWORD=new BCryptPasswordEncoder().encode(USER.getPASSWORD());
            USER.setPASSWORD(ENCODE_PASSWORD);
            User U=USER_REPO.save(USER);

            System.out.println(DATE_FORMATTER.format(CREATED_AT));
            return U;
        }catch(Exception x){
           return null;
        }

    }
}
