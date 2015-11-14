package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.helper.DeviceJson;
import ru.kpfu.itis.model.helper.EmptyJson;
import ru.kpfu.itis.model.helper.RandomDevicesList;
import ru.kpfu.itis.model.helper.UserJson;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.repository.SecListRepository;
import ru.kpfu.itis.repository.UserRepository;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    SecListRepository secListRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @ResponseBody
    @RequestMapping(value = "/device")
    public Device getDevice(@RequestParam("id") Long id) {
        return secListRepository.getDevice(id);
    }

    @ResponseBody
    @RequestMapping(value = "/user/devices")
    public UserJson getUserDevices(@RequestParam("key") String idPass) {
        Long id = Long.parseLong(idPass.substring(0, 3));
        User user = userRepository.searchUserById(id);
        String pass = idPass.substring(3);
        if (!pass.equals(user.getPassword())) {
            return null;
        }
        List<Device> devices = secListRepository.getDevicesByUserId(id);
        return new UserJson(id, user.getName(), devices);
    }

    @ResponseBody
    @RequestMapping(value = "/device/users")
    public DeviceJson getDeviceUsers(@RequestParam("id") Long id) {
        List<User> users = secListRepository.getDeviceUsers(id);
        return new DeviceJson(id, secListRepository.getDevice(id).getName(), users);
    }

    @ResponseBody
    @RequestMapping(value = "/empty")
    public Object checkDevicesEmpty() {
        if (deviceRepository.findAll().isEmpty()) {
            return new EmptyJson(true);
        } else {
            return new EmptyJson(false);
        }
    }

    @RequestMapping(value = "/devices", method = RequestMethod.POST)
    private void saveDevices(@RequestBody RandomDevicesList devicesList) {
        devicesList.generateNames();
        deviceRepository.save(devicesList.getDevices());
        System.out.println("OK");
    }

}
