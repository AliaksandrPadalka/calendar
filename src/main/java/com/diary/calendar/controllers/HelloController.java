package com.diary.calendar.controllers;

import com.diary.calendar.services.OperationService;
import com.diary.calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;
    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Spring 3 MVC Hello World !!!");
        model.addObject("users", userService.getAllUsers());
        model.addObject("operations", operationService.getAllOperations());
        model.setViewName("hello");
        return model;
    }

}
