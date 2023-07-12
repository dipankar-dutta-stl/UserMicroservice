package com.stl.microservice.user.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_gram_panchayat")
public class GramPanchayat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="panchayat_id")
    Long PANCHAYAT_ID;
    @Column(name="panchayat_name")
    String PANCHAYAT_NAME;
    @Column(name="panchayat_unique_id")
    String PANCHAYAT_UNIQUE_ID;
    @Column(name="pincode")
    Long PINCODE;
    @Column(name="panchayat_status")
    String PANCHAYAT_STATUS;
    @Column(name="state_id")
    Long STATE_ID;
    @Column(name="district_id")
    Long DISTRICT_ID;
    @Column(name="taluka_id")
    Long TALIKA_ID;
    @Column(name="village_id")
    Long VILLAGE_ID;
    @Column(name="created_date")
    Date CREATED_DATE;
    @Column(name="updated_date")
    Date UPDATED_DATE;

    public GramPanchayat() {
    }

    public GramPanchayat(Long PANCHAYAT_ID, String PANCHAYAT_NAME, String PANCHAYAT_UNIQUE_ID, Long PINCODE, String PANCHAYAT_STATUS, Long STATE_ID, Long DISTRICT_ID, Long TALIKA_ID, Long VILLAGE_ID, Date CREATED_DATE, Date UPDATED_DATE) {
        this.PANCHAYAT_ID = PANCHAYAT_ID;
        this.PANCHAYAT_NAME = PANCHAYAT_NAME;
        this.PANCHAYAT_UNIQUE_ID = PANCHAYAT_UNIQUE_ID;
        this.PINCODE = PINCODE;
        this.PANCHAYAT_STATUS = PANCHAYAT_STATUS;
        this.STATE_ID = STATE_ID;
        this.DISTRICT_ID = DISTRICT_ID;
        this.TALIKA_ID = TALIKA_ID;
        this.VILLAGE_ID = VILLAGE_ID;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
    }

    public Long getPANCHAYAT_ID() {
        return PANCHAYAT_ID;
    }

    public void setPANCHAYAT_ID(Long PANCHAYAT_ID) {
        this.PANCHAYAT_ID = PANCHAYAT_ID;
    }

    public String getPANCHAYAT_NAME() {
        return PANCHAYAT_NAME;
    }

    public void setPANCHAYAT_NAME(String PANCHAYAT_NAME) {
        this.PANCHAYAT_NAME = PANCHAYAT_NAME;
    }

    public String getPANCHAYAT_UNIQUE_ID() {
        return PANCHAYAT_UNIQUE_ID;
    }

    public void setPANCHAYAT_UNIQUE_ID(String PANCHAYAT_UNIQUE_ID) {
        this.PANCHAYAT_UNIQUE_ID = PANCHAYAT_UNIQUE_ID;
    }

    public Long getPINCODE() {
        return PINCODE;
    }

    public void setPINCODE(Long PINCODE) {
        this.PINCODE = PINCODE;
    }

    public String getPANCHAYAT_STATUS() {
        return PANCHAYAT_STATUS;
    }

    public void setPANCHAYAT_STATUS(String PANCHAYAT_STATUS) {
        this.PANCHAYAT_STATUS = PANCHAYAT_STATUS;
    }

    public Long getSTATE_ID() {
        return STATE_ID;
    }

    public void setSTATE_ID(Long STATE_ID) {
        this.STATE_ID = STATE_ID;
    }

    public Long getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(Long DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    public Long getTALIKA_ID() {
        return TALIKA_ID;
    }

    public void setTALIKA_ID(Long TALIKA_ID) {
        this.TALIKA_ID = TALIKA_ID;
    }

    public Long getVILLAGE_ID() {
        return VILLAGE_ID;
    }

    public void setVILLAGE_ID(Long VILLAGE_ID) {
        this.VILLAGE_ID = VILLAGE_ID;
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
        return "GramPanchayat{" +
                "PANCHAYAT_ID=" + PANCHAYAT_ID +
                ", PANCHAYAT_NAME='" + PANCHAYAT_NAME + '\'' +
                ", PANCHAYAT_UNIQUE_ID='" + PANCHAYAT_UNIQUE_ID + '\'' +
                ", PINCODE=" + PINCODE +
                ", PANCHAYAT_STATUS='" + PANCHAYAT_STATUS + '\'' +
                ", STATE_ID=" + STATE_ID +
                ", DISTRICT_ID=" + DISTRICT_ID +
                ", TALIKA_ID=" + TALIKA_ID +
                ", VILLAGE_ID=" + VILLAGE_ID +
                ", CREATED_DATE=" + CREATED_DATE +
                ", UPDATED_DATE=" + UPDATED_DATE +
                '}';
    }
}
