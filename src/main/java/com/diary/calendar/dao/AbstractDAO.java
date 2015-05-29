package com.diary.calendar.dao;

import com.diary.calendar.entities.AbstractEntity;

public interface AbstractDAO {
    
    void add(AbstractEntity entity);
    void delete(Integer entityId);
    void update(AbstractEntity entity);
}
