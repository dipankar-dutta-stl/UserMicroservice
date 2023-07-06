package com.stl.microservice.user.controller;

import com.stl.microservice.user.jwt.JwtUtills;
import com.stl.microservice.user.model.User;
import com.stl.microservice.user.model.UserDetails;
import com.stl.microservice.user.repo.UserDetailsRepo;
import com.stl.microservice.user.repo.UserRepo;
import com.stl.microservice.user.security.UserLoginDetails;
import com.stl.microservice.user.security.UserLoginDetailsService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/users")
public class UserController {

    /*-------------------------------- CREATING USER REPO VIA DEPENDENCY INJECTION ------------------------------*/
    @Autowired
    UserRepo USER_REPO;
    /*------------------------------- CREATING USER DETAILS REPO VIA DEPENDENCY INJECTION -----------------------*/
    @Autowired
    UserDetailsRepo USER_DETAILS_REPO;

    /*------------------------------- CREATING AUTHENTICATION MANAGER VIA DEPENDENCY INJECTION ---------------------*/
    @Autowired
    AuthenticationManager authenticationManager;


    /*----------------------------- CREATING USER LOGIN DETAILS SERVICE VIA DEPENDENCY INJECTION ----------------------*/
    @Autowired
    UserLoginDetailsService userLoginDetailsService;

    /*----------------------------- CREATING JWT UTILS VIA DEPENDENCY INJECTION --------------------------------*/
    @Autowired
    JwtUtills jwtUtills;

    /*------------------------------- METHOD FOR USER LOGIN -----------------------------*/
    @PostMapping("/login")
    public String login(@RequestBody  User LOGIN_USER){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(LOGIN_USER.getUNIQUE_ID(),LOGIN_USER.getPASSWORD()));
        if(authentication.isAuthenticated()){
            UserLoginDetails userLoginDetails=(UserLoginDetails) userLoginDetailsService.loadUserByUsername(LOGIN_USER.getUNIQUE_ID());
            String TOKEN=jwtUtills.generateJwtToken(userLoginDetails);
            return TOKEN;
        }

       return "LOGIN FAILED";
    }


    /*------------------------------ METHOD FOR CREATE USER ---------------------------*/
    @PostMapping("/register")
    public User createUser(@RequestBody User USER){
        try{
            /*------------------------ GET CURRENT DATE & TIME ----------------------*/
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            USER.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            USER.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            /*--------------------------- ENCODING USER PASSWORD ---------------------*/
            String ENCODE_PASSWORD=new BCryptPasswordEncoder().encode(USER.getPASSWORD());
            USER.setPASSWORD(ENCODE_PASSWORD);
            /*---------------------------- SAVE USER DATA TO DATABASE ---------------------------*/
            User U=USER_REPO.save(USER);
            /*----------------------------- OBJECT OF USER DETAILS -----------------------------*/
            UserDetails USER_DETAILS=new UserDetails();
            /*------------------------------ GENERATING UNIQUE REGISTRATION NO ---------------------*/
            String REG_NO=Long.toHexString(Double.doubleToLongBits(Math.random())).toUpperCase(Locale.ROOT).substring(0,8);
            /*------------------------------ SET DATA TO USER DETAILS -----------------------------*/
            USER_DETAILS.setUSER_ID(U.getUSER_ID());
            USER_DETAILS.setREG_NUMBER(REG_NO);
            USER_DETAILS.setROLE_ID((long) U.getROLE_ID());
            USER_DETAILS.setPANCHAYAT_ID(4L);
            USER_DETAILS.setCREATED_DATE(U.getCREATED_DATE());
            USER_DETAILS.setUPDATED_DATE(U.getUPDATED_DATE());
            /*-------------------------------- SAVE USER DETAILS TO DATABASE ---------------------*/
            USER_DETAILS_REPO.save(USER_DETAILS);
            return U;
        }catch(Exception x){
           System.out.println(x.toString());
           return null;
        }

    }

    /*---------------------------- METHOD FOR LOGOUT USER ------------------------------*/
    @PostMapping("/logout")
    public String logOut(@RequestHeader("Authorization") String token){
        try{
            String RAW_TOKEN=token.substring(7);
            String UNIQUE_ID=jwtUtills.getUniqueIdFromToken(RAW_TOKEN);
            UserLoginDetails userLoginDetails=(UserLoginDetails) userLoginDetailsService.loadUserByUsername(UNIQUE_ID);
            if(jwtUtills.validateJwtToken(RAW_TOKEN,userLoginDetails)){
                String EXP_TOKEN= jwtUtills.expireToken(RAW_TOKEN);
                return EXP_TOKEN;
            }
            return "TOKEN ALREADY EXPIRED";
        }catch (Exception x){
            return "TOKEN ALREADY EXPIRED";
        }


    }

    /*--------------------------- METHOD FOR RESET PASSWORD -------------------------*/
    @PostMapping("/resetPass")
    public String resetPassword(@RequestHeader("Authorization") String TOKEN){
        try{
            String RAW_TOKEN=TOKEN.substring(7);
            String UNIQUE_ID=jwtUtills.getUniqueIdFromToken(RAW_TOKEN);
            String NEW_PASSWORD=new BCryptPasswordEncoder().encode("12345");
            USER_REPO.resetPassword(NEW_PASSWORD,UNIQUE_ID);
            return "PASSWORD RESET SUCCESSFUL\n NEW PASSWORD: 12345";
        }catch(Exception X){
            X.printStackTrace();
            return "RESET PASSWORD PROCESSING FAILED";
        }
    }

    @GetMapping("/view_user")
    public UserDetails viewUser(@RequestHeader("Authorization") String TOKEN){
        String RAW_TOKEN=TOKEN.substring(7);
        String UNIQUE_ID=jwtUtills.getUniqueIdFromToken(RAW_TOKEN);
        Long USER_ID= USER_REPO.findUserIdByUniqueId(UNIQUE_ID);
        UserDetails userDetails=USER_DETAILS_REPO.findByUserId(USER_ID);
        return userDetails;
    }

    @GetMapping("/view_user/{id}")
    public UserDetails viewUserById(@PathVariable("id") Long ID){
        UserDetails userDetails=USER_DETAILS_REPO.findByUserId(ID);
        return userDetails;
    }

}
