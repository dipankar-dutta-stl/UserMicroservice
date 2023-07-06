package com.stl.microservice.user.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_role")
public class Role {

    /*---------------------------------- DECLARING PROPERTIES OF ROLE ---------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int ROLE_ID;
    @Column(name="role_name",nullable = false)
    private String ROLE_NAME;
    @Column(name="status")
    private String STATUS;
    @Column(name="created_date",nullable = false)
    private Date CREATED_DATE;
    @Column(name="updated_date",nullable = false)
    private Date UPDATED_DATE;

    /*------------------------------- DECLARING CONSTRUCTORS ------------------------*/

    public Role() {
    }

    public Role(int ROLE_ID, String ROLE_NAME, String STATUS, Date CREATED_DATE, Date UPDATED_DATE) {
        this.ROLE_ID = ROLE_ID;
        this.ROLE_NAME = ROLE_NAME;
        this.STATUS = STATUS;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
    }

    /*------------------------------- DECLARING GETTERS AND SETTERS ----------------------------*/

    public int getROLE_ID() {
        return ROLE_ID;
    }

    public void setROLE_ID(int ROLE_ID) {
        this.ROLE_ID = ROLE_ID;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
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


    /*---------------------------- IMPLEMENT TO STRING METHOD --------------------------*/

    @Override
    public String toString() {
        return "Role{" +
                "ROLE_ID=" + ROLE_ID +
                ", ROLE_NAME='" + ROLE_NAME + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CREATED_DATE=" + CREATED_DATE +
                ", UPDATED_DATE=" + UPDATED_DATE +
                '}';
    }
}
