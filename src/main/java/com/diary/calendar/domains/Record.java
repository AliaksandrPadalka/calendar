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
 *
 * @author Aliaksandr_Padalka
 */
@Entity
@Table(name = "records")
public class Record implements Serializable {

    private static final Long serialVersionUID = 1L;

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
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public List<Operation> getOperations() {
        return operations;
    }

    /**
     *
     * @param operations
     */
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    /**
     *
     * @return
     */
    public DateTime getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(DateTime date) {
        this.date = date;
    }

}
