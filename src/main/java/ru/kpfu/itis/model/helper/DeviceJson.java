package ru.kpfu.itis.model.helper;

import ru.kpfu.itis.model.User;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class DeviceJson {

    private Long id;

    private String name;

    private List<Long> users;

    public DeviceJson(Long deviceId, String deviceName, List<Long> deviceUsersId) {
        this.id = deviceId;
        this.name = deviceName;
        this.users = deviceUsersId;
    }

    public Long getDeviceId() {
        return id;
    }

    public void setDeviceId(Long deviceId) {
        this.id = deviceId;
    }

    public String getDeviceName() {
        return name;
    }

    public void setDeviceName(String deviceName) {
        this.name = deviceName;
    }

    public List<Long> getDeviceUsers() {
        return users;
    }

    public void setDeviceUsers(List<Long> deviceUsersId) {
        this.users = deviceUsersId;
    }
}