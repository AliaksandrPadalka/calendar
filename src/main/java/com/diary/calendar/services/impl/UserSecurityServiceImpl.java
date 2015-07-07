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

/**
 *
 * @author Aliaksandr_Padalka
 */
public class UserSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)/* throws UsernameNotFoundException*/ {
        UserDetails userDetails = null;

        List<User> users = new ArrayList<>();
        users.addAll((Collection<? extends User>) repository.findAll());

        for (User user : users) {
            if (username.equalsIgnoreCase(user.getName())) {
                userDetails = new org.springframework.security.core.userdetails.User(
                        user.getName(), StringUtils.EMPTY, true, true, true, true, getAuthorities(user.getRole()));
                break;
            }
        }

        return userDetails;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserRole role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority(Constants.ANONIMOUS));

        if (role != null) {
            authList.add(new SimpleGrantedAuthority(role.name()));
        }

        return authList;
    }

}
