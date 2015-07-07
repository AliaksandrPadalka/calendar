package com.diary.calendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Aliaksandr_Padalka
 */
@Controller
public class LoginController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        return model;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = {"/denied", "/login", "/logout"}, method = RequestMethod.GET)
    public ModelAndView showDeniedPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        return model;
    }

}
