package ru.kpfu.itis.model.helper;

import ru.kpfu.itis.model.Device;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class UserJson {

    private String name;

    private List<Device> devices;

    public UserJson(Long id, String name, List<Device> devices) {
        this.name = name;
        this.devices = devices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
