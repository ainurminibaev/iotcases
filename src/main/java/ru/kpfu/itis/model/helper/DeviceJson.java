package ru.kpfu.itis.model.helper;

import org.codehaus.jackson.annotate.JsonProperty;
import ru.kpfu.itis.model.User;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class DeviceJson {

    @JsonProperty("device_id")
    private Long deviceId;

    private String deviceName;

    private List<User> deviceUsers;

    public DeviceJson(Long deviceId, String deviceName, List<User> deviceUsers) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceUsers = deviceUsers;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<User> getDeviceUsers() {
        return deviceUsers;
    }

    public void setDeviceUsers(List<User> deviceUsers) {
        this.deviceUsers = deviceUsers;
    }
}
