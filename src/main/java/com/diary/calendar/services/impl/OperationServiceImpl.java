package com.diary.calendar.services.impl;

import com.diary.calendar.domains.Operation;
import com.diary.calendar.repositories.OperationRepository;
import com.diary.calendar.services.OperationService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h3>class OperationServiceImpl implements interface {@link OperationService}</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class OperationServiceImpl implements OperationService {

    /**
     * <code>Logger</code>
     */
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    /**
     * <code>OperationRepository bean</code>
     */
    @Autowired
    private OperationRepository repository;

    /**
     * <h3>Get all operations.</h3>
     *
     * @return operations
     */
    @Override
    public final List<Operation> getAllOperations() {
        List<Operation> operations = new ArrayList<>();
        operations.addAll((Collection<? extends Operation>) repository.findAll());
        return operations;
    }

    /**
     * <h3>Get operation by <code>operationId</code>.</h3>
     *
     * @param operationId as Long
     * @return operation
     */
    @Override
    public final Operation getOperationByOperationId(final Long operationId) {
        return repository.findOne(operationId);
    }

    /**
     * <h3>Save new or update existing <code>operation</code>.</h3>
     *
     * @param operation as Operation
     * @return operation
     */
    @Override
    public final Operation saveOrUpdateOperation(final Operation operation) {
        return repository.save(operation);
    }

    /**
     * <h3>Delete <code>operation</code>.</h3>
     *
     * @param operation as Operation
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteOperation(final Operation operation) {
        return deleteOperation(operation.getId());
    }

    /**
     * <h3>Delete operation by <code>operationId</code>.</h3>
     *
     * @param operationId as Long
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteOperation(final Long operationId) {
        try {
            repository.delete(operationId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }

}
