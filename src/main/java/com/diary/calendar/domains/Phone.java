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
 * <h3>Entity "Phone".</h3>
 * Describe phone type, code, number and user of the specific phone.
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
     * <h3>Get type.</h3>
     *
     * @return type
     */
    public final PhoneType getType() {
        return type;
    }

    /**
     * <h3>Set type.</h3>
     *
     * @param type
     */
    public final void setType(final PhoneType type) {
        this.type = type;
    }

    /**
     * <h3>Get code.</h3>
     *
     * @return code
     */
    public final String getCode() {
        return code;
    }

    /**
     * <h3>Set code.</h3>
     *
     * @param code
     */
    public final void setCode(final String code) {
        this.code = code;
    }

    /**
     * <h3>Get number.</h3>
     *
     * @return number
     */
    public final String getNumber() {
        return number;
    }

    /**
     * <h3>Set number.</h3>
     *
     * @param number
     */
    public final void setNumber(final String number) {
        this.number = number;
    }

    /**
     * <h3>Get user.</h3>
     *
     * @return user
     */
    public final User getUser() {
        return user;
    }

    /**
     * <h3>Set user.</h3>
     *
     * @param user
     */
    public final void setUser(final User user) {
        this.user = user;
    }

}
