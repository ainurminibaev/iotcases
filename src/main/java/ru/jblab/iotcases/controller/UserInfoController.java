package ru.jblab.iotcases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.jblab.iotcases.dto.Response;
import ru.jblab.iotcases.model.UserInfo;
import ru.jblab.iotcases.service.UserService;

import java.util.List;

/**
 * Created by ainurminibaev on 27.10.15.
 */
@Controller
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserInfo> getAll() {
        return userService.getAllUserInfos();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Response add(@ModelAttribute UserInfo userInfo) {
        userService.save(userInfo);
        return new Response("ok");
    }
}
