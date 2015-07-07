/**
 * <p>
 * License
 * </p>
 */
package com.diary.calendar.repositories;

/**
 * <p>
 * Imports
 * </p>
 */
import com.diary.calendar.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h3>UserRepository for Spring Data</h3>
 *
 * @author Aliaksandr_Padalka
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
