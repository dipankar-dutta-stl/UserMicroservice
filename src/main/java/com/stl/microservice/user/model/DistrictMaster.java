package com.stl.microservice.user.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_district_master")
public class DistrictMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="district_id")
    Integer DISTRICT_ID;
    @Column(name="state_id")
    Integer STATE_ID;
    @Column(name ="district_name")
    String DISTRICT_NAME;
    @Column(name="status")
    String STATUS;


    public DistrictMaster() {
    }

    public DistrictMaster(Integer DISTRICT_ID, Integer STATE_ID, String DISTRICT_NAME, String STATUS) {
        this.DISTRICT_ID = DISTRICT_ID;
        this.STATE_ID = STATE_ID;
        this.DISTRICT_NAME = DISTRICT_NAME;
        this.STATUS = STATUS;
    }

    public Integer getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(Integer DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    public Integer getSTATE_ID() {
        return STATE_ID;
    }

    public void setSTATE_ID(Integer STATE_ID) {
        this.STATE_ID = STATE_ID;
    }

    public String getDISTRICT_NAME() {
        return DISTRICT_NAME;
    }

    public void setDISTRICT_NAME(String DISTRICT_NAME) {
        this.DISTRICT_NAME = DISTRICT_NAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    @Override
    public String toString() {
        return "DistrictMaster{" +
                "DISTRICT_ID=" + DISTRICT_ID +
                ", STATE_ID=" + STATE_ID +
                ", DISTRICT_NAME='" + DISTRICT_NAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                '}';
    }
}
