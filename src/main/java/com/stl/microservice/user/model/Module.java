package com.stl.microservice.user.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="module_id")
    int MODULE_ID;
    @Column(name="module_name")
    String MODULE_NAME;
    @Column(name="description")
    String DESCRIPTION;
    @Column(name="module_image")
    String MODULE_IMAGE;
    @Column(name="module_url")
    String MODULE_URL;
    @Column(name="module_status")
    String MODULE_STATUS;
    @Column(name="is_redirection")
    int IS_REDIRECTION;
    @Column(name="created_date")
    Date CREATED_DATE;
    @Column(name="updated_date")
    Date UPDATED_DATE;

    public Module() {
    }

    public Module(int MODULE_ID, String MODULE_NAME, String DESCRIPTION, String MODULE_IMAGE, String MODULE_URL, String MODULE_STATUS, int IS_REDIRECTION, Date CREATED_DATE, Date UPDATED_DATE) {
        this.MODULE_ID = MODULE_ID;
        this.MODULE_NAME = MODULE_NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.MODULE_IMAGE = MODULE_IMAGE;
        this.MODULE_URL = MODULE_URL;
        this.MODULE_STATUS = MODULE_STATUS;
        this.IS_REDIRECTION = IS_REDIRECTION;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATED_DATE = UPDATED_DATE;
    }


    public int getMODULE_ID() {
        return MODULE_ID;
    }

    public void setMODULE_ID(int MODULE_ID) {
        this.MODULE_ID = MODULE_ID;
    }

    public String getMODULE_NAME() {
        return MODULE_NAME;
    }

    public void setMODULE_NAME(String MODULE_NAME) {
        this.MODULE_NAME = MODULE_NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getMODULE_IMAGE() {
        return MODULE_IMAGE;
    }

    public void setMODULE_IMAGE(String MODULE_IMAGE) {
        this.MODULE_IMAGE = MODULE_IMAGE;
    }

    public String getMODULE_URL() {
        return MODULE_URL;
    }

    public void setMODULE_URL(String MODULE_URL) {
        this.MODULE_URL = MODULE_URL;
    }

    public String getMODULE_STATUS() {
        return MODULE_STATUS;
    }

    public void setMODULE_STATUS(String MODULE_STATUS) {
        this.MODULE_STATUS = MODULE_STATUS;
    }

    public int getIS_REDIRECTION() {
        return IS_REDIRECTION;
    }

    public void setIS_REDIRECTION(int IS_REDIRECTION) {
        this.IS_REDIRECTION = IS_REDIRECTION;
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
        return "Modules{" +
                "MODULE_ID=" + MODULE_ID +
                ", MODULE_NAME='" + MODULE_NAME + '\'' +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                ", MODULE_IMAGE='" + MODULE_IMAGE + '\'' +
                ", MODULE_URL='" + MODULE_URL + '\'' +
                ", MODULE_STATUS='" + MODULE_STATUS + '\'' +
                ", IS_REDIRECTION=" + IS_REDIRECTION +
                ", CREATED_DATE=" + CREATED_DATE +
                ", UPDATED_DATE=" + UPDATED_DATE +
                '}';
    }
}
