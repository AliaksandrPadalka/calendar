package com.diary.calendar.services;

import com.diary.calendar.domains.Operation;
import java.util.List;

/**
 * <h3>interface OperationService</h3>
 *
 * @author Aliaksandr_Padalka
 */
public interface OperationService {

    /**
     * <h3>Get all operations.</h3>
     *
     * @return operations
     */
    List<Operation> getAllOperations();

    /**
     * <h3>Get operation by <code>operationId</code>.</h3>
     *
     * @param operationId as Long
     * @return operation
     */
    Operation getOperationByOperationId(final Long operationId);

    /**
     * <h3>Save new or update existing <code>operation</code>.</h3>
     *
     * @param operation as Operation
     * @return operation
     */
    Operation saveOrUpdateOperation(final Operation operation);

    /**
     * <h3>Delete <code>operation</code>.</h3>
     *
     * @param operation as Operation
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteOperation(final Operation operation);

    /**
     * <h3>Delete operation by <code>operationId</code>.</h3>
     *
     * @param operationId as Long
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteOperation(final Long operationId);

}
