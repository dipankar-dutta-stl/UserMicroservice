package com.stl.microservice.user.controller;

import com.stl.microservice.user.jwt.JwtUtills;
import com.stl.microservice.user.model.Module;
import com.stl.microservice.user.model.Role;
import com.stl.microservice.user.model.User;
import com.stl.microservice.user.model.UserDetails;
import com.stl.microservice.user.repo.ModuleRepo;
import com.stl.microservice.user.repo.RoleRepo;
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
import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/users")
public class UserController {

    /*-------------------------------- CREATING USER REPO VIA DEPENDENCY INJECTION ------------------------------*/
    @Autowired
    UserRepo USER_REPO;
    /*------------------------------- CREATING USER DETAILS REPO VIA DEPENDENCY INJECTION -----------------------*/
    @Autowired
    UserDetailsRepo USER_DETAILS_REPO;

    /*------------------------------ CREATING ROLE REPO VIA DEPENDENCY INJECTION ----------------------------*/
    @Autowired
    RoleRepo ROLE_REPO;

    /*------------------------------ CREATING MODULE REPO VIA DEPENDENCY INJECTION ----------------------------*/
    @Autowired
    ModuleRepo MODULE_REPO;

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
        try {
            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(LOGIN_USER.getUNIQUE_ID(),LOGIN_USER.getPASSWORD()));
            if(authentication.isAuthenticated()){
                String USER_STATUS= USER_REPO.getUserStatusByUniqueId(LOGIN_USER.getUNIQUE_ID());
                if(USER_STATUS.equals("active")){
                    UserLoginDetails userLoginDetails=(UserLoginDetails) userLoginDetailsService.loadUserByUsername(LOGIN_USER.getUNIQUE_ID());
                    String TOKEN=jwtUtills.generateJwtToken(userLoginDetails);
                    return TOKEN;
                }else{
                    return "USER DELETED";
                }

            } else{
                return "LOGIN FAILED";
            }
        }catch (Exception X){
            X.printStackTrace();
            return "LOGIN ERROR";
        }
    }


    /*------------------------------ METHOD FOR CREATE USER ---------------------------*/
    @PostMapping("/register")
    public String register_user(@RequestBody User USER){
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
            USER.setROLE_ID(4);
            User U=USER_REPO.save(USER);
            return U.getUSER_ID().toString();
        }catch(Exception X){
            X.printStackTrace();
            return null;
        }

    }
    @PostMapping("/add_usr_details")
    public String add_user_data(@RequestBody UserDetails USER_DETAILS){

        try{
            /*------------------------ GET CURRENT DATE & TIME ----------------------*/
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            /*------------------------------ GENERATING UNIQUE REGISTRATION NO ---------------------*/
            String REG_NO=Long.toHexString(Double.doubleToLongBits(Math.random())).toUpperCase(Locale.ROOT).substring(0,8);
            /*------------------------------ SET DATA TO USER DETAILS -----------------------------*/
            USER_DETAILS.setREG_NUMBER(REG_NO);
            USER_DETAILS.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            USER_DETAILS.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            /*-------------------------------- SAVE USER DETAILS TO DATABASE ---------------------*/
            System.out.println(USER_DETAILS);
            USER_DETAILS_REPO.save(USER_DETAILS);
            return "USER DETAILS CREATED" ;
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

    /*----------------------------------- METHOD FOR VIEW LOGGED IN USER ----------------------------------*/
    @GetMapping("/view_user")
    public UserDetails viewUser(@RequestHeader("Authorization") String TOKEN){
        String RAW_TOKEN=TOKEN.substring(7);
        String UNIQUE_ID=jwtUtills.getUniqueIdFromToken(RAW_TOKEN);
        Long USER_ID= USER_REPO.findUserIdByUniqueId(UNIQUE_ID);
        UserDetails userDetails=USER_DETAILS_REPO.findByUserId(USER_ID);
        return userDetails;
    }

    /*----------------------------------- METHOD FOR VIEW LOGGED IN USER BY ID ----------------------------------*/
    @GetMapping("/view_user/{id}")
    public UserDetails viewUserById(@PathVariable("id") Long ID){
        UserDetails userDetails=USER_DETAILS_REPO.findByUserId(ID);
        return userDetails;
    }


    /*----------------------------------- METHOD FOR EDIT USER BY ID ----------------------------------*/
    @RequestMapping(value="/edit_user",method = RequestMethod.PUT)
    public UserDetails editUser(@RequestBody UserDetails UPDATED_USER_DETAILS){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            UPDATED_USER_DETAILS.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            UPDATED_USER_DETAILS.setWHATSAPP_NO(new BCryptPasswordEncoder().encode(UPDATED_USER_DETAILS.getWHATSAPP_NO()));
            System.out.println(UPDATED_USER_DETAILS);
            USER_DETAILS_REPO.save(UPDATED_USER_DETAILS);
            return UPDATED_USER_DETAILS;
        }catch(Exception X){
            return  null;
        }

    }


    /*----------------------------------- METHOD FOR DELETE  USER  BY ID ----------------------------------*/
    @DeleteMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable("id") String UID){
        USER_REPO.updateUserStatusByUserId(0,UID);
        USER_DETAILS_REPO.updateUserStatusByUserId(0,UID);
        return "USER DELETED";
    }


    /*----------------------------------- METHOD FOR VIEW ALL ROLES ----------------------------------*/
    @GetMapping("/view_roles")
    public List<Role> viewRoles(){
        return ROLE_REPO.findAll();
    }

    /*----------------------------------- METHOD FOR VIEW ROLE BY ID ----------------------------------*/
    @GetMapping("/view_roles/{id}")
    public Role viewRolesById(@PathVariable("id") int ROLE_ID){
        try{
            return ROLE_REPO.findById(ROLE_ID).get();
        }catch(Exception X){
            return null;
        }

    }


    /*----------------------------------- METHOD FOR EDIT ROLE BY ID ----------------------------------*/
    @PutMapping("/edit_roles/{id}")
    public String editRolesById(@PathVariable("id") int ROLE_ID,@RequestHeader("Authorization") String TOKEN,Role UPDATED_ROLE){
        try{
            Date UPDATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String RAW_TOKEN=TOKEN.substring(7);
            String UNIQUE_ID=jwtUtills.getUniqueIdFromToken(RAW_TOKEN);
            String ROLE_NAME=USER_REPO.findRoleNameByUniqueId(UNIQUE_ID);
            if(ROLE_NAME.equals("Admin")){
                Role OLD_ROLE=ROLE_REPO.findById(ROLE_ID).get();
                UPDATED_ROLE.setROLE_ID(ROLE_ID);
                UPDATED_ROLE.setCREATED_DATE(OLD_ROLE.getCREATED_DATE());
                UPDATED_ROLE.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(UPDATED_AT)));
                ROLE_REPO.save(UPDATED_ROLE);
                return "ROLE UPDATED";
            }
            else{
                return "YOU ARE NOT ADMIN";
            }
        }
        catch (Exception X){
            return "ERROR OCCURS";
        }

    }

    /*----------------------------------- METHOD FOR DELETE ROLE BY ID ----------------------------------*/
    @DeleteMapping("/delete_roles/{id}")
    public String deleteRolesById(@PathVariable("id") int ROLE_ID,@RequestHeader("Authorization") String TOKEN){
        try{
            String RAW_TOKEN=TOKEN.substring(7);
            String UNIQUE_ID=jwtUtills.getUniqueIdFromToken(RAW_TOKEN);
            String ROLE_NAME=USER_REPO.findRoleNameByUniqueId(UNIQUE_ID);
            if(ROLE_NAME.equals("Admin")){
                ROLE_REPO.deleteRoleById("deactive",ROLE_ID);
                return "ROLE DELETED";
            }
            else{
                return "YOU ARE NOT ADMIN";
            }
        }
        catch (Exception X){
            X.printStackTrace();
            return "ERROR OCCURS";
        }

    }

    /*----------------------------------- METHOD FOR ADD MODULE ----------------------------------*/
    @PostMapping("/add_modules")
    public String add_modules(@RequestBody Module NEW_MODULE){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NEW_MODULE.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            NEW_MODULE.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            MODULE_REPO.save(NEW_MODULE);
            return "MODULE CREATED";
        }catch(Exception x){
            return "ERROR IN ADDING MODULE";
        }

    }

    /*----------------------------------- METHOD FOR VIEW ALL MODULE ----------------------------------*/
    @GetMapping("/view_modules")
    public List<Module> view_modules(){
        return MODULE_REPO.findAll();
    }

    /*----------------------------------- METHOD FOR VIEW MODULE BY ID ----------------------------------*/
    @GetMapping("/view_modules/{id}")
    public Module view_modules_by_id(@PathVariable("id") int MID){
        return MODULE_REPO.findById(MID).get();
    }


    /*----------------------------------- METHOD FOR DELETE MODULE BY ID ----------------------------------*/
    @DeleteMapping("/delete_modules/{id}")
    public String delete_modules(@PathVariable("id") int MID){
        MODULE_REPO.deleteModuleById(MID);
        return "MODULE DELETED";
    }


}
