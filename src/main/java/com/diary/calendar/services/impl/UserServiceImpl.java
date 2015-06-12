package com.diary.calendar.services.impl;

import com.diary.calendar.domains.User;
import com.diary.calendar.repositories.UserRepository;
import com.diary.calendar.services.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll((Collection<? extends User>) userRepository.findAll());
        return users;
    }

    @Override
    public User getUserByUserId(final Long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User saveOrUpdateUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(final User user) {
        return deleteUser(user.getId());
    }

    @Override
    public boolean deleteUser(final Long userId) {
        try {
            userRepository.delete(userId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }
}
