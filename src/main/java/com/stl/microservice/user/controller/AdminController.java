package com.stl.microservice.user.controller;

import com.stl.microservice.user.jwt.JwtUtills;
import com.stl.microservice.user.model.StateMaster;
import com.stl.microservice.user.repo.StateMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    JwtUtills JWT_UTILLS;

    @Autowired
    StateMasterRepo STATE_MASTER_REPO;

    @PostMapping("/add_state")
    public String add_state(@RequestBody StateMaster NEW_STATE){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NEW_STATE.setCREATE_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            NEW_STATE.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            STATE_MASTER_REPO.save(NEW_STATE);
            return "NEW STATE ADDED";
        }catch(Exception X){
            return "ERROR WIHILE ADDING STATE";
        }
    }


    @GetMapping("/view_state")
    public List<StateMaster> view_state(){
        try{
            return STATE_MASTER_REPO.findAll();
        }catch(Exception X){
            return null;
        }
    }

    @GetMapping("/view_state/{id}")
    public StateMaster view_state_by_id(@PathVariable("id") int SID){
        try{
            return STATE_MASTER_REPO.findById(SID).get();
        }catch(Exception X){
            return null;
        }
    }

    @DeleteMapping("/delete_state/{id}")
    public String delete_state(@PathVariable("id") int SID){
        try{
            STATE_MASTER_REPO.deleteStateMasterById(SID);
            return "STATE DELETED";
        }catch(Exception X){
            return "ERROR WHILE STATE DELETING";
        }
    }


}
