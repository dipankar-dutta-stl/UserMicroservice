package com.stl.microservice.user.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_user_module_mapping")
public class UserModuleMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mapping_id")
    Long MAPPING_ID;
    @Column(name="module_id")
    Long MODULE_ID;
    @Column(name="user_id")
    Long USER_ID;
    @Column(name="entity_type")
    String ENTITY_TYPE;
    @Column(name="status")
    String STATUS;
    @Column(name="created_date")
    Date CREATED_DATE;
    @Column(name="updated_date")
    Date UPDATEED_DATE;

    public UserModuleMapping() {
    }

    public UserModuleMapping(Long MAPPING_ID, Long MODULE_ID, Long USER_ID, String ENTITY_TYPE, String STATUS, Date CREATED_DATE, Date UPDATEED_DATE) {
        this.MAPPING_ID = MAPPING_ID;
        this.MODULE_ID = MODULE_ID;
        this.USER_ID = USER_ID;
        this.ENTITY_TYPE = ENTITY_TYPE;
        this.STATUS = STATUS;
        this.CREATED_DATE = CREATED_DATE;
        this.UPDATEED_DATE = UPDATEED_DATE;
    }

    public Long getMAPPING_ID() {
        return MAPPING_ID;
    }

    public void setMAPPING_ID(Long MAPPING_ID) {
        this.MAPPING_ID = MAPPING_ID;
    }

    public Long getMODULE_ID() {
        return MODULE_ID;
    }

    public void setMODULE_ID(Long MODULE_ID) {
        this.MODULE_ID = MODULE_ID;
    }

    public Long getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Long USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getENTITY_TYPE() {
        return ENTITY_TYPE;
    }

    public void setENTITY_TYPE(String ENTITY_TYPE) {
        this.ENTITY_TYPE = ENTITY_TYPE;
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

    public Date getUPDATEED_DATE() {
        return UPDATEED_DATE;
    }

    public void setUPDATEED_DATE(Date UPDATEED_DATE) {
        this.UPDATEED_DATE = UPDATEED_DATE;
    }

    @Override
    public String toString() {
        return "UserModuleMapping{" +
                "MAPPING_ID=" + MAPPING_ID +
                ", MODULE_ID=" + MODULE_ID +
                ", USER_ID=" + USER_ID +
                ", ENTITY_TYPE='" + ENTITY_TYPE + '\'' +
                ", STATUS='" + STATUS + '\'' +
                ", CREATED_DATE=" + CREATED_DATE +
                ", UPDATEED_DATE=" + UPDATEED_DATE +
                '}';
    }
}
