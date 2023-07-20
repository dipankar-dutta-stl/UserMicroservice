package com.stl.microservice.user.controller;

import com.stl.microservice.user.jwt.JwtUtills;
import com.stl.microservice.user.model.*;
import com.stl.microservice.user.repo.*;
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

    @Autowired
    VillageMasterRepo VILLAGE_MASTER_REPO;

    @Autowired
    GramPanchayatRepo GRAM_PANCHAYAT_REPO;


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

    @PutMapping("/edit_state")
    public String update_state(@RequestBody StateMaster UPDATED_STATE){
        try{
            STATE_MASTER_REPO.save(UPDATED_STATE);
            return "STATE UPDATED";
        }catch(Exception x){
            return "STATE NOT UPDATED: ERROR";
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

    @GetMapping("/view_district_by_state/{id}")
    public List<DistrictMaster> view_district_by_state(@PathVariable("id") Long STATE_ID){
        try{
            DISTRICT_MASTER_REPO.findDistrictByStateId(STATE_ID);
            return DISTRICT_MASTER_REPO.findDistrictByStateId(STATE_ID);
        }catch(Exception x){
            return null;
        }

    }

    @PutMapping("/edit_district")
    public void update_district(@RequestBody DistrictMaster UPDATED_DISTRICT){
        try{
            DISTRICT_MASTER_REPO.save(UPDATED_DISTRICT);

        }catch(Exception x){
            x.printStackTrace();
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

    @PostMapping("/add_talukas")
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


    @GetMapping("/view_talukas/{id}")
    public TalukaMaster view_taluka(@PathVariable("id") int TID){
        try{

            return TALUKA_MASTER_REPO.findById(TID).get();
        }catch(Exception X){
            return null;
        }
    }

    @PutMapping("/edit_talukas")
    public void update_talukas(@RequestBody TalukaMaster UPDATED_TALUKA){
        try{
            TALUKA_MASTER_REPO.save(UPDATED_TALUKA);

        }catch(Exception x){
            x.printStackTrace();
        }
    }


    @DeleteMapping("/delete_talukas/{id}")
    public String delete_taluka(@PathVariable("id") int TID){
        try{
            TALUKA_MASTER_REPO.deleteTalukaById(TID);
            return "TALUKA DELETED";
        }catch(Exception X){
            return "ERROR WHILE DELETING TALUKA";
        }
    }


    /*--------------------------------------- REST API FOR VILLAGE -----------------------------*/

    @PostMapping("/add_village")
    public String add_village(@RequestBody VillageMaster NEW_VILLAGE){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NEW_VILLAGE.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            NEW_VILLAGE.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            VILLAGE_MASTER_REPO.save(NEW_VILLAGE);
            return "NEW VILLAGE ADDED";
        }catch(Exception X){
            return "ERROR WHILE ADDING VILLAGE";
        }
    }


    @GetMapping("/view_village")
    public List<VillageMaster> view_village(){
        try{
            return VILLAGE_MASTER_REPO.findAll();
        }catch(Exception X){
            return null;
        }
    }


    @GetMapping("/view_village/{id}")
    public VillageMaster view_village(@PathVariable("id") int VID){
        try{

            return VILLAGE_MASTER_REPO.findById(VID).get();
        }catch(Exception X){
            return null;
        }
    }


    @DeleteMapping("/delete_village/{id}")
    public String delete_village(@PathVariable("id") int VID){
        try{
            VILLAGE_MASTER_REPO.deleteVillageById(VID);
            return "VILLAGE DELETED";
        }catch(Exception X){
            return "ERROR WHILE DELETING VILLAGE";
        }
    }


    /*--------------------------------------- REST API FOR GRAM PANCHAYAT -----------------------------*/

    @PostMapping("/add_grampanchayat")
    public String add_grampanchayat(@RequestBody GramPanchayat NEW_GRAM_PANCHAYAT){
        try{
            Date CREATED_AT=new Date();
            SimpleDateFormat DATE_FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            NEW_GRAM_PANCHAYAT.setCREATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            NEW_GRAM_PANCHAYAT.setUPDATED_DATE(DATE_FORMATTER.parse(DATE_FORMATTER.format(CREATED_AT)));
            GRAM_PANCHAYAT_REPO.save(NEW_GRAM_PANCHAYAT);
            return "NEW GRAM PANCHAYAT ADDED";
        }catch(Exception X){
            return "ERROR WHILE ADDING GRAM PANCHAYAT";
        }
    }

    @GetMapping("/view_grampanchayat")
    public List<GramPanchayat> view_grampanchayat(){
        try{
            return GRAM_PANCHAYAT_REPO.findAll();
        }catch(Exception X){
            X.printStackTrace();
            return null;
        }
    }


    @GetMapping("/view_grampanchayat/{id}")
    public GramPanchayat view_grampanchayat(@PathVariable("id") Long GPID){
        try{

            return GRAM_PANCHAYAT_REPO.findById(GPID).get();
        }catch(Exception X){
            return null;
        }
    }

    @DeleteMapping("/delete_grampanchayat/{id}")
    public String delete_grampanchayat(@PathVariable("id") int GPID){
        try{
            GRAM_PANCHAYAT_REPO.deleteGramPanchayatById(GPID);
            return "GRAM PANCHAYAT DELETED";
        }catch(Exception X){
            return "ERROR WHILE DELETING GRAM PANCHAYAT";
        }
    }
}
