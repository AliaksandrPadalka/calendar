package com.diary.calendar.services.impl;

import com.diary.calendar.domains.User;
import com.diary.calendar.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * <h3>UserServiceImplTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String NAME_ADMIN = "admin";
    private static final String NAME_ADMIN_NEW = "new admin";
    private static final String NAME_USER = "user";
    private static final long ID_ADMIN = 1L;
    private static final long ID_USER = 2L;

    @Mock
    private UserRepository repo;

    @InjectMocks
    private UserServiceImpl service;

    private User admin;
    private User user;
    private User admin_new;
    private User user_new;

    @Before
    public void init() {
        admin = new User();
        admin.setId(ID_ADMIN);
        admin.setName(NAME_ADMIN);
        user = new User();
        user.setId(ID_USER);
        user.setName(NAME_USER);

        List<User> users = new ArrayList<>(Arrays.asList(admin, user));

        admin_new = new User();
        admin_new.setId(ID_ADMIN);
        admin_new.setName(NAME_ADMIN_NEW);

        user_new = new User();
        user_new.setName(NAME_USER);

        when(repo.findAll()).thenReturn(users);
        when(repo.findOne(ID_ADMIN)).thenReturn(admin);
        when(repo.save(user_new)).thenReturn(user);
        when(repo.save(admin_new)).thenReturn(admin_new);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = service.getAllUsers();
        assertThat(users).isNotNull();
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void testGetUserByUserId() {
        User gettingUser = service.getUserByUserId(ID_ADMIN);
        assertThat(gettingUser).isNotNull();
        assertThat(gettingUser.getId()).isEqualTo(ID_ADMIN);
        assertThat(gettingUser.getName()).isEqualTo(NAME_ADMIN);
    }

    @Test
    public void testSaveOrUpdateUser() {
        User saved_user = service.saveOrUpdateUser(user_new);
        assertThat(saved_user).isNotNull();
        assertThat(saved_user.getId()).isEqualTo(ID_USER);
        assertThat(saved_user.getName()).isEqualTo(NAME_USER);

        User saved_admin = service.saveOrUpdateUser(admin_new);
        assertThat(saved_admin).isNotNull();
        assertThat(saved_admin.getId()).isEqualTo(ID_ADMIN);
        assertThat(saved_admin.getName()).isEqualTo(NAME_ADMIN_NEW);
    }

    @Test
    public void testDeleteUser_User() {
        boolean flag = service.deleteUser(user);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeleteUser_Long() {
        boolean flag = service.deleteUser(ID_USER);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeleteUser_IllegalArgumentException() {
        doThrow(new IllegalArgumentException()).when(repo).delete(ID_USER);
        boolean flag = service.deleteUser(ID_USER);
        assertThat(flag).isEqualTo(false);
    }

}
