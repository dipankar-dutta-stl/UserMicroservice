package com.stl.microservice.user.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_village_master")
public class VillageMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="village_id")
    Integer VILLAGE_ID;
    @Column(name="taluka_id")
    Integer TALUKA_ID;
    @Column(name="village_name")
    String VILLAGE_NAME;
    @Column(name="status")
    String STATUS;
    @Column(name="created_date")
    Date CREATED_DATE;
    @Column(name="updated_date")
    Date UPDATED_DATE;

    public VillageMaster() {
    }

    public VillageMaster(Integer VILLAGE_ID, Integer TALUKA_ID, String VILLAGE_NAME, String STATUS, Date CREATED_DATE, Date UPDATED_DATE) {
        this.VILLAGE_ID = VILLAGE_ID;
        this.TALUKA_ID = TALUKA_ID;
        this.VILLAGE_NAME = VILLAGE_NAME;
        this.STATUS = STATUS;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
    }

    public Integer getVILLAGE_ID() {
        return VILLAGE_ID;
    }

    public void setVILLAGE_ID(Integer VILLAGE_ID) {
        this.VILLAGE_ID = VILLAGE_ID;
    }

    public Integer getTALUKA_ID() {
        return TALUKA_ID;
    }

    public void setTALUKA_ID(Integer TALUKA_ID) {
        this.TALUKA_ID = TALUKA_ID;
    }

    public String getVILLAGE_NAME() {
        return VILLAGE_NAME;
    }

    public void setVILLAGE_NAME(String VILLAGE_NAME) {
        this.VILLAGE_NAME = VILLAGE_NAME;
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
        return "VillageMaster{" +
                "VILLAGE_ID=" + VILLAGE_ID +
                ", TALUKA_ID=" + TALUKA_ID +
                ", VILLAGE_NAME='" + VILLAGE_NAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CREATED_DATE=" + CREATED_DATE +
                ", UPDATED_DATE=" + UPDATED_DATE +
                '}';
    }
}
