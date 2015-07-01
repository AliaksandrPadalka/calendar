package com.diary.calendar.services.impl;

import com.diary.calendar.domains.Operation;
import com.diary.calendar.repositories.OperationRepository;
import com.diary.calendar.services.OperationService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationServiceImpl implements OperationService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private OperationRepository repository;

    @Override
    public List<Operation> getAllOperations() {
        List<Operation> operations = new ArrayList<>();
        operations.addAll((Collection<? extends Operation>) repository.findAll());
        return operations;
    }

    @Override
    public Operation getOperationByOperationId(final Long operationId) {
        return repository.findOne(operationId);
    }

    @Override
    public Operation saveOrUpdateOperation(final Operation operation) {
        return repository.save(operation);
    }

    @Override
    public boolean deleteOperation(final Operation operation) {
        return deleteOperation(operation.getId());
    }

    @Override
    public boolean deleteOperation(final Long operationId) {
        try {
            repository.delete(operationId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }

}
