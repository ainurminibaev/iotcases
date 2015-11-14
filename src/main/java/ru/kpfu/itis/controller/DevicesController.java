package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.model.helper.DeviceJson;
import ru.kpfu.itis.repository.SecListRepository;
import ru.kpfu.itis.repository.UserRepository;

import java.util.List;

/**
 * Created by vlad on 14.11.15.
 */
@Controller
public class DevicesController {

    @Autowired
    SecListRepository secListRepository;

    @RequestMapping(value = "/users/{uid}/devices")
    public String getAllUserDevices(@PathVariable("uid") Long uid, Model model) {
        List<Device> devices = secListRepository.getDevicesByUserId(uid);
        model.addAttribute("devices", devices);
        return "user-devices";
    }

    @RequestMapping(value = "/devices/{id}")
    public String getDevice(@PathVariable("id") Long id, Model model) {
        Device device = secListRepository.getDevice(id);
        model.addAttribute("device", device);
        return "device";
    }

    @ResponseBody
    @RequestMapping(value = "/devices/{id}/json")
    public DeviceJson getUserDevices(@PathVariable("id") Long id) {
        List<User> users = secListRepository.getDeviceUsers(id);
        return new DeviceJson(id, "<device_name>", users);
    }

}
