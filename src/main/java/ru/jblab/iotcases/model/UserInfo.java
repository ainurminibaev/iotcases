package ru.jblab.iotcases.model;

import javax.persistence.*;

/**
 * Created by ainurminibaev on 27.10.15.
 */
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String fname;

    private String lname;

    private String mname;

    private String highSchool;

    private Long eduStartYear;

    private Long enuEndYear;

    private String city;

    private String profession;

    private String experience;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public Long getEduStartYear() {
        return eduStartYear;
    }

    public void setEduStartYear(Long eduStartYear) {
        this.eduStartYear = eduStartYear;
    }

    public Long getEnuEndYear() {
        return enuEndYear;
    }

    public void setEnuEndYear(Long enuEndYear) {
        this.enuEndYear = enuEndYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
