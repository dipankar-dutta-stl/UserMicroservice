package com.stl.microservice.user.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_state_master")
public class StateMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="state_id")
    int STATE_ID;
    @Column(name="state_name")
    String STATE_NAME;
    @Column(name="status")
    String STATUS;
    @Column(name="created_date")
    Date CREATE_DATE;
    @Column(name="updated_date")
    Date UPDATED_DATE;

    public StateMaster() {
    }

    public StateMaster(int STATE_ID, String STATE_NAME, String STATUS, Date CREATE_DATE, Date UPDATED_DATE) {
        this.STATE_ID = STATE_ID;
        this.STATE_NAME = STATE_NAME;
        this.STATUS = STATUS;
        this.CREATE_DATE = CREATE_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
    }

    public int getSTATE_ID() {
        return STATE_ID;
    }

    public void setSTATE_ID(int STATE_ID) {
        this.STATE_ID = STATE_ID;
    }

    public String getSTATE_NAME() {
        return STATE_NAME;
    }

    public void setSTATE_NAME(String STATE_NAME) {
        this.STATE_NAME = STATE_NAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public Date getUPDATED_DATE() {
        return UPDATED_DATE;
    }

    public void setUPDATED_DATE(Date UPDATED_DATE) {
        this.UPDATED_DATE = UPDATED_DATE;
    }

    @Override
    public String toString() {
        return "StateMaster{" +
                "STATE_ID=" + STATE_ID +
                ", STATE_NAME='" + STATE_NAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CREATE_DATE=" + CREATE_DATE +
                ", UPDATED_DATE=" + UPDATED_DATE +
                '}';
    }
}
