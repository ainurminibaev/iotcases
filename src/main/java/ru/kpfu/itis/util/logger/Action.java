package ru.kpfu.itis.util.logger;

import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;

import java.util.Date;

/**
 * Created by vlad on 15.11.15.
 */
public class Action {

    private Date date;

    private User user;

    private Device device;

    private boolean access;

    public Action(User user, Device device, boolean access) {
        this.date = new Date();
        this.user = user;
        this.device = device;
        this.access = access;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
