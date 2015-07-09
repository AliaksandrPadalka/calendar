package com.diary.calendar.services.impl;

import com.diary.calendar.domains.User;
import com.diary.calendar.enums.UserRole;
import com.diary.calendar.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <h3>UserSecurityServiceImplTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
@RunWith(MockitoJUnitRunner.class)
public class UserSecurityServiceImplTest {

    private static final String NAME_ADMIN = "admin";
    private static final String NAME_USER = "user";
    private static final long ID_ADMIN = 1L;
    private static final long ID_USER = 2L;

    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserSecurityServiceImpl service;

    @Before
    public void init() {
        User admin = new User();
        admin.setId(ID_ADMIN);
        admin.setName(NAME_ADMIN);
        admin.setRole(UserRole.ADMIN);
        User user = new User();
        user.setId(ID_USER);
        user.setName(NAME_USER);

        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(user);

        when(repo.findAll()).thenReturn(users);
    }

    @Test
    public void testLoadUserByUsername() {
        UserDetails user = service.loadUserByUsername(NAME_ADMIN);
        assertThat(user.getUsername()).isEqualTo(NAME_ADMIN);
        assertThat(user.getAuthorities().size()).isEqualTo(2);
        user = service.loadUserByUsername(NAME_USER);
        assertThat(user.getUsername()).isEqualTo(NAME_USER);
        assertThat(user.getAuthorities().size()).isEqualTo(1);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testForEmptyUsername_UsernameNotFoundException() {
        service.loadUserByUsername(StringUtils.EMPTY);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testNotFoundUsername_UsernameNotFoundException() {
        service.loadUserByUsername(NAME_USER + NAME_USER);
    }

}
