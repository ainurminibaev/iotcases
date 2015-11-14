package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.helper.RandomDevicesList;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.service.DeviceService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vlad on 15.11.15.
 */
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public void saveDevices(RandomDevicesList devicesList) {
        List<Device> devices = devicesList.getDevices()
                .stream()
                .map(Device::new)
                .map(it -> {
                    it.setName("Device " + it.getId());
                    return it;
                })
                .collect(Collectors.toList());
        deviceRepository.save(devices);
    }
}
