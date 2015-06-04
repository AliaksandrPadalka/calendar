package com.diary.calendar.services;

import com.diary.calendar.domains.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserByUserId(Long userId);
    User saveOrUpdateUser(User user);
    boolean deleteUser(User user);
    boolean deleteUser(Long userId);
}
