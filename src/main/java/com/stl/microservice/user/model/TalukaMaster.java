package com.stl.microservice.user.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_taluka_master")
public class TalukaMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="taluka_id")
    Integer TALUKA_ID;
    @Column(name = "district_id")
    Integer DISTRICT_ID;
    @Column(name="taluka_name")
    String TALUKA_NAME;
    @Column(name = "status")
    String STATUS;
    @Column(name = "created_date")
    Date CREATED_DATE;
    @Column(name = "updated_date")
    Date UPDATED_DATE;

    public TalukaMaster() {
    }

    public TalukaMaster(Integer TALUKA_ID, Integer DISTRICT_ID, String TALUKA_NAME, String STATUS, Date CREATED_DATE, Date UPDATED_DATE) {
        this.TALUKA_ID = TALUKA_ID;
        this.DISTRICT_ID = DISTRICT_ID;
        this.TALUKA_NAME = TALUKA_NAME;
        this.STATUS = STATUS;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
    }

    public Integer getTALUKA_ID() {
        return TALUKA_ID;
    }

    public void setTALUKA_ID(Integer TALUKA_ID) {
        this.TALUKA_ID = TALUKA_ID;
    }

    public Integer getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(Integer DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    public String getTALUKA_NAME() {
        return TALUKA_NAME;
    }

    public void setTALUKA_NAME(String TALUKA_NAME) {
        this.TALUKA_NAME = TALUKA_NAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }

    public Date getUPDATED_DATE() {
        return UPDATED_DATE;
    }

    public void setUPDATED_DATE(Date UPDATED_DATE) {
        this.UPDATED_DATE = UPDATED_DATE;
    }

    @Override
    public String toString() {
        return "TalukaMaster{" +
                "TALUKA_ID=" + TALUKA_ID +
                ", DISTRICT_ID=" + DISTRICT_ID +
                ", TALUKA_NAME='" + TALUKA_NAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CREATED_DATE=" + CREATED_DATE +
                ", UPDATED_DATE=" + UPDATED_DATE +
                '}';
    }
}
