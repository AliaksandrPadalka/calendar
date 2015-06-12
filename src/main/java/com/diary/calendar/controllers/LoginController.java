package com.diary.calendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        return model;
    }
}
