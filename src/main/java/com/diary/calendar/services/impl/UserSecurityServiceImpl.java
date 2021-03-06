package com.diary.calendar.services.impl;

import com.diary.calendar.Constants;
import com.diary.calendar.domains.User;
import com.diary.calendar.enums.UserRole;
import com.diary.calendar.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <h3>class UserSecurityServiceImpl implements interface {@link UserDetailsService}</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class UserSecurityServiceImpl implements UserDetailsService {

    /**
     * <code>UserRepository bean</code>
     */
    @Autowired
    private UserRepository repository;

    /**
     * <h3>Get {@link UserDetails} <code>user</code>.</h3>
     *
     * @param username as String
     * @return userDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public final UserDetails loadUserByUsername(final String username)/* throws UsernameNotFoundException*/ {

        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("Username should not be empty.");
        }

        UserDetails userDetails = null;

        List<User> users = new ArrayList<>();
        users.addAll((Collection<? extends User>) repository.findAll());

        for (User user : users) {
            if (username.equals(user.getName())) {
                userDetails = new org.springframework.security.core.userdetails.User(
                        user.getName(), StringUtils.EMPTY, true, true, true, true, getAuthorities(user.getRole()));
                break;
            }
        }

        if (userDetails == null) {
            throw new UsernameNotFoundException(String.format("Username \'%s\' not found.", username));
        }

        return userDetails;
    }

    /**
     * <h3>Utility method</h3>
     *
     * @param role as UserRole
     * @return authList
     */
    private Collection<? extends GrantedAuthority> getAuthorities(final UserRole role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(Constants.Access.ANONIMOUS));

        if (role != null) {
            authList.add(new SimpleGrantedAuthority(role.name()));
        }

        return authList;
    }

}
