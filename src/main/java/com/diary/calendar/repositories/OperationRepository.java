package com.diary.calendar.repositories;

import com.diary.calendar.domains.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aliaksandr_Padalka
 */
@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {
    
}
