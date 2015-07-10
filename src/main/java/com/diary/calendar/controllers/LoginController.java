package com.diary.calendar.controllers;

import com.diary.calendar.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>class LoginController</h3>
 *
 * @author Aliaksandr_Padalka
 */
@Controller
public class LoginController {

    /**
     * <h3>Return administrative view.</h3>
     *
     * @return model
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public final ModelAndView showAdminPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName(Constants.Pages.URL_PAGE_ADMIN);
        return model;
    }

    /**
     * <h3>Return view if access denied.</h3>
     *
     * @return model
     */
    @RequestMapping(value = {"/denied", "/logout"}, method = RequestMethod.GET)
    public final ModelAndView showDeniedPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName(Constants.Pages.URL_PAGE_403);
        return model;
    }

    /**
     * <h3>Return login view</h3>
     *
     * @return model
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final ModelAndView showLoginPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName(Constants.Pages.URL_PAGE_LOGIN);
        return model;
    }

}
