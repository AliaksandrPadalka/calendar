package com.diary.calendar.domains;

import com.diary.calendar.enums.UserRole;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    
    @Id
    @GeneratedValue
    @Column(name="userId")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, targetEntity = Phone.class)
    private List<Phone> phones;
    private UserRole role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, targetEntity = Record.class)
    private List<Record> records;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
