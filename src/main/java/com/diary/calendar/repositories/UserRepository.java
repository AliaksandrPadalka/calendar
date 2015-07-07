package com.diary.calendar.repositories;

import com.diary.calendar.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository for Spring Data
 *
 * @author Aliaksandr_Padalka
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
