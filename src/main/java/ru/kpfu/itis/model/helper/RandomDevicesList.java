package ru.kpfu.itis.model.helper;

import ru.kpfu.itis.model.Device;

import java.rmi.server.UID;
import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
public class RandomDevicesList {

    private List<Device> devices;

    public RandomDevicesList() {
    }

    public RandomDevicesList(List<Device> devices) {
        this.devices = devices;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public void generateNames() {
        for (int i = 0; i < devices.size(); i++) {
            devices.get(i).setName("Generated Device " + new UID().toString());
        }
    }
}