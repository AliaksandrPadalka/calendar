package com.diary.calendar.controllers;

import com.diary.calendar.Constants;
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
     * Return administrative view.
     *
     * @return model
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName(Constants.Pages.URL_PAGE_ADMIN);
        return model;
    }

    /**
     * Return view if access denied.
     *
     * @return model
     */
    @RequestMapping(value = {"/denied", "/login", "/logout"}, method = RequestMethod.GET)
    public ModelAndView showDeniedPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName(Constants.Pages.URL_PAGE_403);
        return model;
    }

}
