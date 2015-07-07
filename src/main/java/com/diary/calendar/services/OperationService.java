package com.diary.calendar.services;

import com.diary.calendar.domains.Operation;
import java.util.List;

/**
 * interface OperationService
 *
 * @author Aliaksandr_Padalka
 */
public interface OperationService {

    /**
     * Get all operations
     *
     * @return operations
     */
    List<Operation> getAllOperations();

    /**
     * Get operation by <code>operationId</code>.
     *
     * @param operationId
     * @return operation
     */
    Operation getOperationByOperationId(final Long operationId);

    /**
     * Save new or update existing <code>operation</code>.
     *
     * @param operation
     * @return operation
     */
    Operation saveOrUpdateOperation(final Operation operation);

    /**
     * Delete <code>operation</code>.
     *
     * @param operation
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteOperation(final Operation operation);

    /**
     * Delete operation by <code>operationId</code>.
     *
     * @param operationId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteOperation(final Long operationId);

}
