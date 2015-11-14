package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.helper.*;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.repository.SecListRepository;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    DeviceRepository deviceRepository;

//    TODO НЕ УДАЛЯЙТЕ ПОКА!
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
    public UserJson getUserDevices(@RequestParam("uid") String pin) {
        User user = checkPin(pin);
        List<Device> devices = secListRepository.getDevicesByUserId(user.getId());
        return new UserJson(user.getId(), user.getName(), devices);
    }

    private User checkPin(String pin) {
        Long id = Long.parseLong(pin.substring(0, 3));
        User user = userRepository.searchUserById(id);
        if (user == null) {
            return null;
        }
        String pass = pin.substring(3);
        if (!pass.equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/api/data")
    public DataJson getData(@RequestParam("password") String pin) {
        User user = checkPin(pin);
        //TODO check is admin
        if (user == null) {
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

    @RequestMapping(value = "/api/devices", method = RequestMethod.POST, headers = "content-type=application/json,application/xml")
    private void saveDevices(@RequestBody RandomDevicesList devicesList) {
        //TODO to service and add transactional
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

    @RequestMapping(value = "/api/user/change", method = RequestMethod.POST, headers = "content-type=application/json,application/xml")
    private void editUser(@RequestBody ChangingUser changingUser) {
        //TODO to service and add transactional
        User user = checkPin(changingUser.getPin());
        if (user == null) {
            return;
        }
        if (!"".equals(changingUser.getName())) {
            user.setName(changingUser.getName());
        }
        if (!"".equals(changingUser.getPassword())) {
            user.setPassword(changingUser.getPassword());
        }
        userRepository.updateUser(user);
    }


}
