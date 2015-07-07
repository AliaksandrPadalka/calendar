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
 * <h3>class UserServiceImpl implements interface {@link UserService}</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserRepository repository;

    /**
     * <h3>Get all users.</h3>
     *
     * @return users
     */
    @Override
    public final List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users.addAll((Collection<? extends User>) repository.findAll());
        return users;
    }

    /**
     * <h3>Get user by <code>userId</code>.</h3>
     *
     * @param userId
     * @return user
     */
    @Override
    public final User getUserByUserId(final Long userId) {
        return repository.findOne(userId);
    }

    /**
     * <h3>Save new or update existing <code>user</code>.</h3>
     *
     * @param user
     * @return user
     */
    @Override
    public final User saveOrUpdateUser(final User user) {
        return repository.save(user);
    }

    /**
     * <h3>Delete <code>user</code>.</h3>
     *
     * @param user
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteUser(final User user) {
        return deleteUser(user.getId());
    }

    /**
     * <h3>Delete user by <code>userId</code>.</h3>
     *
     * @param userId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteUser(final Long userId) {
        try {
            repository.delete(userId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }
}
