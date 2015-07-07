package com.diary.calendar.services;

import com.diary.calendar.domains.User;
import java.util.List;

/**
 * interface UserService
 *
 * @author Aliaksandr_Padalka
 */
public interface UserService {

    /**
     * Get all users.
     *
     * @return users
     */
    List<User> getAllUsers();

    /**
     * Get user by <code>userId</code>.
     *
     * @param userId
     * @return user
     */
    User getUserByUserId(Long userId);

    /**
     * Save new or update existing <code>user</code>.
     *
     * @param user
     * @return user
     */
    User saveOrUpdateUser(User user);

    /**
     * Delete <code>user</code>.
     *
     * @param user
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteUser(User user);

    /**
     * Delete user by <code>userId</code>.
     *
     * @param userId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteUser(Long userId);

}
