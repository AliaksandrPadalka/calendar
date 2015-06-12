package com.diary.calendar.controllers;

import com.diary.calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView model = new ModelAndView();
        ModelMap modelMap = model.getModelMap();
        modelMap.addAttribute("message", "Spring 3 MVC Hello World !!!");
        modelMap.addAttribute("users", userService.getAllUsers());
        model.setViewName("hello");
        return model;
    }

}
