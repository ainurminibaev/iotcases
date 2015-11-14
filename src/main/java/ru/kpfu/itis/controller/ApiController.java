package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.helper.DeviceJson;
import ru.kpfu.itis.model.helper.UserJson;
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
        return new DeviceJson(id, "<device_name>", users);
    }

}
