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
import ru.kpfu.itis.model.helper.ChangingUser;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.repository.SecListRepository;
import ru.kpfu.itis.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    @RequestMapping(value = "/devices")
    public List<Device> getDevice(@RequestParam("id") Long id) {
        return secListRepository.getDevicesByUserId(id);
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
    @RequestMapping(value = "/user")
    public UserJson getUserDevices(@RequestParam("pin") String pin) {
        User user = checkPin(pin);
        List<Device> devices = secListRepository.getDevicesByUserId(user.getId());
        return new UserJson(user.getId(), user.getName(), devices);
    }

    @ResponseBody
    @RequestMapping(value = "/device")
    public DeviceJson getDeviceUsers(@RequestParam("id") Long id) {
        List<Long> usersId = secListRepository.getDeviceUsersId(id);
        return new DeviceJson(id, secListRepository.getDevice(id).getName(), usersId);
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

    @RequestMapping(value = "/user/change", method = RequestMethod.POST)
    private void editUser(@RequestBody ChangingUser changingUser) {
        //TODO to service and add transactional
        User user = checkPin(changingUser.getPin());
        if (user == null) {
            return;
        }
        if (!changingUser.getName().equals("")) {
            user.setName(changingUser.getName());
        }
        if (!changingUser.getPassword().equals("")) {
            user.setPassword(changingUser.getPassword());
        }
        userRepository.updateUser(user);
    }


}
