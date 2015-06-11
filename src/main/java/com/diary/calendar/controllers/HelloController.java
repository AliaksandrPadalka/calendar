package com.diary.calendar.controllers;

import com.diary.calendar.domains.User;
import com.diary.calendar.enums.UserRole;
import com.diary.calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("User" + i);
            user.setRole(UserRole.USER);
            userService.saveOrUpdateUser(user);
        }

        model.addAttribute("message", "Spring 3 MVC Hello World !!!");
        return "hello";
    }

}
