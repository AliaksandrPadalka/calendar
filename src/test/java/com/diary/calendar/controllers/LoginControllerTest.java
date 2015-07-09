package com.diary.calendar.controllers;

import com.diary.calendar.Constants;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>LoginControllerTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class LoginControllerTest {

    //@InjectMocks
    private LoginController controller;

    @Before
    public void init() {
        controller = new LoginController();
    }

    @Test
    public void testShowAdminPage() {
        ModelAndView model = controller.showAdminPage();
        assertThat(model.getViewName()).isEqualTo(Constants.Pages.URL_PAGE_ADMIN);
    }

    @Test
    public void testShowDeniedPage() {
        ModelAndView model = controller.showDeniedPage();
        assertThat(model.getViewName()).isEqualTo(Constants.Pages.URL_PAGE_403);
    }

}
