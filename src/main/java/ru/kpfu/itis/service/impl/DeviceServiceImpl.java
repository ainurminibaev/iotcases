package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.helper.RandomDevicesList;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.service.DeviceService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Transactional
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
