package ru.jblab.iotcases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.jblab.iotcases.util.SecurityContextUtil;
import ru.jblab.iotcases.model.User;

/**
 * Created by ainurminibaev on 27.08.14.
 */
@Controller
public class LoginController {
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String renderLogin(@RequestParam(required = false) String error, ModelMap map) {
        if (error != null) {
            map.addAttribute("error", true);
        }
        User currentUser = SecurityContextUtil.getCurrentUser();
        if (currentUser != null) {
            return "redirect:/events";
        }
        return "login";
    }
}
