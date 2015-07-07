package com.diary.calendar.domains;

import com.diary.calendar.enums.PhoneType;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity "Phone". Describe phone type, code, number and user of the specific phone.
 *
 * @author Aliaksandr_Padalka
 */
@Entity
@Table(name = "phones")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneId")
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Column(name = "code")
    private String code;

    @Column(name = "number")
    private String number;

    @JoinColumn(name = "userId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    /**
     * Get id.
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set id.
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get type.
     *
     * @return type
     */
    public PhoneType getType() {
        return type;
    }

    /**
     * Set type.
     *
     * @param type
     */
    public void setType(PhoneType type) {
        this.type = type;
    }

    /**
     * Get code.
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set code.
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get number.
     *
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Set number.
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Get user.
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set user.
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
