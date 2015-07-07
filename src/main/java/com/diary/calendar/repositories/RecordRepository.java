package com.diary.calendar.repositories;

import com.diary.calendar.domains.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RecordRepository for Spring Data
 *
 * @author Aliaksandr_Padalka
 */
@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {

}
