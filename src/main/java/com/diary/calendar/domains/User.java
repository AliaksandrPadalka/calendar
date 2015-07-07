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
 * <h3>Entity "User".</h3>
 * Describe user name, list of contact phones, user role and list of records for the specific user.
 *
 * @author Aliaksandr_Padalka
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

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
     * <h3>Get id.</h3>
     *
     * @return id
     */
    public final Long getId() {
        return id;
    }

    /**
     * <h3>Set id.</h3>
     *
     * @param id
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * <h3>Get name.</h3>
     *
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * <h3>Set name.</h3>
     *
     * @param name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * <h3>Get phones.</h3>
     *
     * @return phones
     */
    public final List<Phone> getPhones() {
        return phones;
    }

    /**
     * <h3>Set phones.</h3>
     *
     * @param phones
     */
    public final void setPhones(final List<Phone> phones) {
        this.phones = phones;
    }

    /**
     * <h3>Get role.</h3>
     *
     * @return role
     */
    public final UserRole getRole() {
        return role;
    }

    /**
     * <h3>Set role.</h3>
     *
     * @param role
     */
    public final void setRole(final UserRole role) {
        this.role = role;
    }

    /**
     * <h3>Get records.</h3>
     *
     * @return records
     */
    public final List<Record> getRecords() {
        return records;
    }

    /**
     * <h3>Set records.</h3>
     *
     * @param records
     */
    public final void setRecords(final List<Record> records) {
        this.records = records;
    }

}
