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
 * Entity "Record". Describe user, date and list of operations for the specific record.
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

    /**
     * Get operations.
     *
     * @return operations
     */
    public List<Operation> getOperations() {
        return operations;
    }

    /**
     * Set operations.
     *
     * @param operations
     */
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    /**
     * Get date.
     *
     * @return date
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * Set date.
     *
     * @param date
     */
    public void setDate(DateTime date) {
        this.date = date;
    }

}
