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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * <h3>Entity "Operation".</h3>
 * Describe short name, duration and description of the specific operation.
 *
 * @author Aliaksandr_Padalka
 */
@Entity
@Table(name = "operations")
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operationId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Double duration;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_chooses",
            joinColumns = {
                @JoinColumn(name = "operationId", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "recordId", nullable = false, updatable = false)})
    private List<Record> records;

    /**
     * <h3>Return id.</h3>
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
     * <h3>Get description.</h3>
     *
     * @return description
     */
    public final String getDescription() {
        return description;
    }

    /**
     * <h3>Set description.</h3>
     *
     * @param description
     */
    public final void setDescription(final String description) {
        this.description = description;
    }

    /**
     * <h3>Get duration.</h3>
     *
     * @return duration
     */
    public final Double getDuration() {
        return duration;
    }

    /**
     * <h3>Set duration.</h3>
     *
     * @param duration
     */
    public final void setDuration(final Double duration) {
        this.duration = duration;
    }

    /**
     * <h3>Get list of records.</h3>
     *
     * @return records
     */
    public final List<Record> getRecord() {
        return records;
    }

    /**
     * <h3>Set list of records.</h3>
     *
     * @param records
     */
    public final void setRecord(final List<Record> records) {
        this.records = records;
    }

}
