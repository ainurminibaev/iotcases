package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.model.Device;
import ru.kpfu.itis.repository.DeviceRepository;
import ru.kpfu.itis.service.UserService;

import java.util.List;

@Controller
public class AdminPanelController {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/panel")
    public String getAdminPanelPage() {
        return "panel";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute UserForm userForm) {
        userService.saveUser(userForm);
        return "panel";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getSavePage(Model map) {
        List<Device> devices = deviceRepository.findAll();
        map.addAttribute("devices", devices);
        return "create";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser() {
//        userService.saveUser(userForm);

        return "panel";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdateUserPage() {
        return "update";
    }

}
