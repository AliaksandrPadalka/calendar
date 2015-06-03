package com.diary.calendar.domains;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class Record {
    
    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="entity_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name="recordId")
    private Long id;
    @JoinColumn(name = "userId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "record", fetch = FetchType.LAZY, targetEntity = Operation.class)
    private List<Operation> operations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}
