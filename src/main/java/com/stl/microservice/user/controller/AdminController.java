package com.stl.microservice.user.controller;

import com.stl.microservice.user.jwt.JwtUtills;
import com.stl.microservice.user.model.DistrictMaster;
import com.stl.microservice.user.model.StateMaster;
import com.stl.microservice.user.model.TalukaMaster;
import com.stl.microservice.user.repo.DistrictMasterRepo;
import com.stl.microservice.user.repo.StateMasterRepo;
import com.stl.microservice.user.repo.TalukaMasterRepo;
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
    @Autowired
    DistrictMasterRepo DISTRICT_MASTER_REPO;

    @Autowired
    TalukaMasterRepo TALUKA_MASTER_REPO;


    /*------------------------------------------- REST API FOR STATE -----------------------------------*/
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

    /*--------------------------------------- REST API FOR DISTRICT -----------------------------*/
    @PostMapping("/add_district")
    public String add_district(@RequestBody DistrictMaster NEW_DISTRICT){
        try{

            DISTRICT_MASTER_REPO.save(NEW_DISTRICT);
            return "NEW DISTRICT ADDED";
        }catch(Exception X){
            return "ERROR WIHILE ADDING DISTRICT";
        }
    }


    @GetMapping("/view_district")
    public List<DistrictMaster> view_district(){
        try{
            return DISTRICT_MASTER_REPO.findAll();
        }catch(Exception X){
            return null;
        }
    }

    @GetMapping("/view_district/{id}")
    public DistrictMaster view_district_by_id(@PathVariable("id") int DID){
        try{
            return DISTRICT_MASTER_REPO.findById(DID).get();
        }catch(Exception X){
            return null;
        }
    }


    @DeleteMapping("/delete_district/{id}")
    public String delete_district_by_id(@PathVariable("id") int DID){
        try{
            DISTRICT_MASTER_REPO.deleteDistrictById(DID);
            return "DISTRICT DELETED";
        }catch(Exception X){
            return "ERROR WHILE DELETING DISTRICT";
        }
    }

    /*--------------------------------------- REST API FOR TALUKA -----------------------------*/

    @PostMapping("/add_taluka")
    public String add_taluka(@RequestBody TalukaMaster NEW_TALUKA){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NEW_TALUKA.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            NEW_TALUKA.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            TALUKA_MASTER_REPO.save(NEW_TALUKA);
            return "NEW TALUKA ADDED";
        }catch(Exception X){
            return "ERROR WHILE ADDING TALUKA";
        }
    }


    @GetMapping("/view_taluka")
    public List<TalukaMaster> view_taluka(){
        try{
            return TALUKA_MASTER_REPO.findAll();
        }catch(Exception X){
            return null;
        }
    }


    @GetMapping("/view_taluka/{id}")
    public TalukaMaster add_taluka(@PathVariable("id") int TID){
        try{

            return TALUKA_MASTER_REPO.findById(TID).get();
        }catch(Exception X){
            return null;
        }
    }


    @DeleteMapping("/delete_taluka/{id}")
    public String delete_taluka(@PathVariable("id") int TID){
        try{
            TALUKA_MASTER_REPO.deleteTalukaById(TID);
            return "TALUKA DELETED";
        }catch(Exception X){
            return "ERROR WHILE ADDING TALUKA";
        }
    }
}
