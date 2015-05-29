package com.diary.calendar.entities;

import com.diary.calendar.enums.UserRole;
import java.util.List;

public class User extends AbstractEntity {
    
    private String name;
    private List<Phone> phones;
    private UserRole role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
