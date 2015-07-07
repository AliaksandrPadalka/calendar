package com.diary.calendar.controllers;

import com.diary.calendar.Constants;
import com.diary.calendar.services.OperationService;
import com.diary.calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>class HelloController</h3>
 *
 * @author Aliaksandr_Padalka
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;
    @Autowired
    private OperationService operationService;

    /**
     * <h3>Return default view.</h3>
     *
     * @return model
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public final ModelAndView getDefaultPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("message", "Spring 3 MVC Hello World !!!");
        model.addObject("users", userService.getAllUsers());
        model.addObject("operations", operationService.getAllOperations());
        model.setViewName(Constants.Pages.URL_PAGE_HELLO);
        return model;
    }

}
