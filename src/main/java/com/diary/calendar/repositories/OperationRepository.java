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
import com.diary.calendar.domains.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <h3>OperationRepository for Spring Data</h3>
 *
 * @author Aliaksandr_Padalka
 */
@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
