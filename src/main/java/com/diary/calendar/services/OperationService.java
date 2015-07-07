package com.diary.calendar.services;

import com.diary.calendar.domains.Operation;
import java.util.List;

/**
 *
 * @author Aliaksandr_Padalka
 */
public interface OperationService {

    /**
     *
     * @return
     */
    List<Operation> getAllOperations();

    /**
     *
     * @param operationId
     * @return
     */
    Operation getOperationByOperationId(final Long operationId);

    /**
     *
     * @param operation
     * @return
     */
    Operation saveOrUpdateOperation(final Operation operation);

    /**
     *
     * @param operation
     * @return
     */
    boolean deleteOperation(final Operation operation);

    /**
     *
     * @param operationId
     * @return
     */
    boolean deleteOperation(final Long operationId);

}
