package ru.kpfu.itis.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ru.kpfu.itis.model.Device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vladislav on 14.11.15.
 */
public class DeviceCheckbox {

    public static List<DeviceCheckForm> getDeviceEditForm(List<Device> devices, List<Device> devicesUser) {
        List<DeviceCheckForm> list = new ArrayList<>();
        for (Device device : devices) {
            DeviceCheckForm form = new DeviceCheckForm();
            form.setDevice(device);
            if (devicesUser.contains(device)) {
                form.setChecked(Boolean.TRUE);
            } else {
                form.setChecked(Boolean.FALSE);
            }
            list.add(form);
        }
        return list;
    }

}
