package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.enums.Role;
import ru.kpfu.itis.model.helper.*;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.repository.SecListRepository;
import ru.kpfu.itis.repository.UserRepository;
import ru.kpfu.itis.service.DeviceService;
import ru.kpfu.itis.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
@Controller
public class ApiController {

    @Autowired
    SecListRepository secListRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    DeviceService deviceService;

    @Autowired
    DeviceRepository deviceRepository;

//    НЕ УДАЛЯЙТЕ ПОКА!
//    @ResponseBody
//    @RequestMapping(value = "get/accesses")
//    public List<Device> getDevice(@RequestParam("uid") Long id) {
//        return secListRepository.getDevicesByUserId(id);
//    }

//    @ResponseBody
//    @RequestMapping(value = "get/accesses")
//    public DeviceJson getDeviceUsers(@RequestParam("id") Long id) {
//        List<Long> usersId = secListRepository.getDeviceUsersId(id);
//        return new DeviceJson(id, secListRepository.getDevice(id).getName(), usersId);
//    }

    @ResponseBody
    @RequestMapping(value = "get/accesses")
    public UserJson getUserDevices(@RequestParam("pin") String pin) {
        User user = userService.checkPin(pin);
        List<Device> devices = secListRepository.getDevicesByUserId(user.getId());
        return new UserJson(user.getId(), user.getName(), devices);
    }

    @ResponseBody
    @RequestMapping(value = "/api/data")
    public DataJson getData(@RequestParam("password") String pin) {
        User user = userService.checkPin(pin);
        if (user == null || !user.getRole().equals(Role.ROLE_ADMIN)) {
            return null;
        }
        List<Device> devices = deviceRepository.findAll();
        List<DeviceJson> devicesJson = new ArrayList<>(devices.size());
        for (Device d : devices) {
            devicesJson.add(new DeviceJson(d.getId(), d.getName(), secListRepository.getDeviceUsersId(d.getId())));
        }
        List<User> users = userRepository.getAllUser();

        return new DataJson(devicesJson, users);
    }

    @ResponseBody
    @RequestMapping(value = "/api/empty")
    public Object checkDevicesEmpty() {
        if (deviceRepository.findAll().isEmpty()) {
            return new EmptyJson(true);
        } else {
            return new EmptyJson(false);
        }
    }

    @RequestMapping(value = "/api/devices", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveDevices(@RequestBody RandomDevicesList devicesList) {
        deviceService.saveDevices(devicesList);
    }

    @RequestMapping(value = "/api/user/change", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editUser(@RequestBody ChangingUser changingUser) {
        userService.updateUser(changingUser);
    }


}
