package ru.kpfu.itis.util;

import ru.kpfu.itis.model.Device;

/**
 * Created by vladislav on 14.11.15.
 */
public class DeviceCheckForm {

    private Device device;
    private Boolean checked;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
