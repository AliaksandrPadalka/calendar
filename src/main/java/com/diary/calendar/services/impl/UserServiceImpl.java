package com.diary.calendar.services.impl;

import com.diary.calendar.domains.User;
import com.diary.calendar.repositories.UserRepository;
import com.diary.calendar.services.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * class UserServiceImpl implements interface {@link UserService}
 *
 * @author Aliaksandr_Padalka
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserRepository repository;

    /**
     * Get all users.
     *
     * @return users
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll((Collection<? extends User>) repository.findAll());
        return users;
    }

    /**
     * Get user by <code>userId</code>.
     *
     * @param userId
     * @return user
     */
    @Override
    public User getUserByUserId(final Long userId) {
        return repository.findOne(userId);
    }

    /**
     * Save new or update existing <code>user</code>.
     *
     * @param user
     * @return user
     */
    @Override
    public User saveOrUpdateUser(final User user) {
        return repository.save(user);
    }

    /**
     * Delete <code>user</code>.
     *
     * @param user
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public boolean deleteUser(final User user) {
        return deleteUser(user.getId());
    }

    /**
     * Delete user by <code>userId</code>.
     *
     * @param userId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public boolean deleteUser(final Long userId) {
        try {
            repository.delete(userId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }
}
