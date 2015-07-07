package com.diary.calendar.domains;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * <h3>Entity "Record".</h3>
 * Describe user, date and list of operations for the specific record.
 *
 * @author Aliaksandr_Padalka
 */
@Entity
@Table(name = "records")
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordId")
    private Long id;

    @JoinColumn(name = "userId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToMany(mappedBy = "records", fetch = FetchType.EAGER)
    private List<Operation> operations;

    @Column(name = "date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime date;

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

    /**
     * <h3>Get operations.</h3>
     *
     * @return operations
     */
    public final List<Operation> getOperations() {
        return operations;
    }

    /**
     * <h3>Set operations.</h3>
     *
     * @param operations
     */
    public final void setOperations(final List<Operation> operations) {
        this.operations = operations;
    }

    /**
     * <h3>Get date.</h3>
     *
     * @return date
     */
    public final DateTime getDate() {
        return date;
    }

    /**
     * <h3>Set date.</h3>
     *
     * @param date
     */
    public final void setDate(final DateTime date) {
        this.date = date;
    }

}
