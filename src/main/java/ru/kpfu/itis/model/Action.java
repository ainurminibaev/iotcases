package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vlad on 15.11.15.
 */
@Entity
@Table(name = "actiontable")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "act_date")
    private Date date;

    @Column(name = "username")
    private String user;

    private String device;
    @Column(name = "has_access")
    private boolean access;

    public Action() {
    }

    public Action(String user, String device, boolean access) {
        date = new Date();
        this.user = user;
        this.device = device;
        this.access = access;
    }

    public Action(Date date, String user, String device, boolean access) {
        this.date = date;
        this.user = user;
        this.device = device;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
