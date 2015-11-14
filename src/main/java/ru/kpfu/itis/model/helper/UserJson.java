package ru.kpfu.itis.model.helper;

import ru.kpfu.itis.model.Device;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class UserJson {

    private Long userId;

    private String userName;

    private List<Device> devices;

    public UserJson(Long userId, String userName, List<Device> devices) {
        this.userId = userId;
        this.userName = userName;
        this.devices = devices;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
