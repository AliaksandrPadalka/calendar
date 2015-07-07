package com.diary.calendar.domains;

import com.diary.calendar.enums.UserRole;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aliaksandr_Padalka
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, targetEntity = Phone.class)
    private List<Phone> phones;

    @Column(name = "userrole")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, targetEntity = Record.class)
    private List<Record> records;

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public List<Phone> getPhones() {
        return phones;
    }

    /**
     *
     * @param phones
     */
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    /**
     *
     * @return
     */
    public UserRole getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     *
     * @param records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }

}
