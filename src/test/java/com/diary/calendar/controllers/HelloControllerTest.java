package com.diary.calendar.controllers;

import com.diary.calendar.Constants;
import com.diary.calendar.domains.Operation;
import com.diary.calendar.domains.User;
import com.diary.calendar.services.OperationService;
import com.diary.calendar.services.UserService;
import java.util.ArrayList;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h3>HelloControllerTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;
    @Mock
    private OperationService operationService;

    @InjectMocks
    private HelloController controller;

    @Before
    public void init() {
        when(userService.getAllUsers()).thenReturn(new ArrayList<User>());
        when(operationService.getAllOperations()).thenReturn(new ArrayList<Operation>());
    }

    @Test
    public void testGetDefaultPage() throws Exception {
        ModelAndView model = controller.getDefaultPage();
        assertThat(model.getViewName()).isEqualTo(Constants.Pages.URL_PAGE_HELLO);
        Map<String, Object> map = model.getModel();
        assertThat(map.size()).isEqualTo(3);
        assertThat(map.get("message")).isNotNull();
        assertThat(map.get("users")).isNotNull();
        assertThat(map.get("operations")).isNotNull();
    }

}
