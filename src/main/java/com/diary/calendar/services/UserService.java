package com.diary.calendar.services;

import com.diary.calendar.domains.User;
import java.util.List;

/**
 * <h3>interface UserService</h3>
 *
 * @author Aliaksandr_Padalka
 */
public interface UserService {

    /**
     * <h3>Get all users.</h3>
     *
     * @return users
     */
    List<User> getAllUsers();

    /**
     * <h3>Get user by <code>userId</code>.</h3>
     *
     * @param userId
     * @return user
     */
    User getUserByUserId(final Long userId);

    /**
     * <h3>Save new or update existing <code>user</code>.</h3>
     *
     * @param user
     * @return user
     */
    User saveOrUpdateUser(final User user);

    /**
     * <h3>Delete <code>user</code>.</h3>
     *
     * @param user
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteUser(final User user);

    /**
     * <h3>Delete user by <code>userId</code>.</h3>
     *
     * @param userId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteUser(final Long userId);

}
