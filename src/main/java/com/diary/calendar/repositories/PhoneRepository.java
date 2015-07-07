package com.diary.calendar.repositories;

import com.diary.calendar.domains.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h3>PhoneRepository for Spring Data</h3>
 *
 * @author Aliaksandr_Padalka
 */
@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {

}
