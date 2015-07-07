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
 * Entity "Operation". Describe short name, duration and description of the specific operation.
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
     * Return id.
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
     * Get name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get duration.
     *
     * @return duration
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * Set duration.
     *
     * @param duration
     */
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    /**
     * Get list of records.
     *
     * @return records
     */
    public List<Record> getRecord() {
        return records;
    }

    /**
     * Set list of records.
     *
     * @param records
     */
    public void setRecord(List<Record> records) {
        this.records = records;
    }

}
