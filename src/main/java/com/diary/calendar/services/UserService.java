package com.diary.calendar.services;

import com.diary.calendar.domains.User;
import java.util.List;

/**
 *
 * @author Aliaksandr_Padalka
 */
public interface UserService {

    /**
     *
     * @return
     */
    List<User> getAllUsers();

    /**
     *
     * @param userId
     * @return
     */
    User getUserByUserId(Long userId);

    /**
     *
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     *
     * @param user
     * @return
     */
    boolean deleteUser(User user);

    /**
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);

}
