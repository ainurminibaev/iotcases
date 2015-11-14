package ru.kpfu.itis.model.helper;

import ru.kpfu.itis.model.User;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class DataJson {

    private List<DeviceJson> devices;

    private List<User> users;

    public DataJson() {
    }

    public DataJson(List<DeviceJson> devices, List<User> users) {
        this.devices = devices;
        this.users = users;
    }

    public List<DeviceJson> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceJson> devices) {
        this.devices = devices;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
