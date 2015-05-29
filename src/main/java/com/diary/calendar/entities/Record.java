package com.diary.calendar.entities;

import java.util.List;

public class Record extends AbstractEntity {
    
    private User user;
    private List<Operation> operations;

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
