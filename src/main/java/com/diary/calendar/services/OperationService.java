package com.diary.calendar.services;

import com.diary.calendar.domains.Operation;
import java.util.List;

public interface OperationService {

    List<Operation> getAllOperations();

    Operation getOperationByOperationId(final Long operationId);

    Operation saveOrUpdateOperation(final Operation operation);

    boolean deleteOperation(final Operation operation);

    boolean deleteOperation(final Long operationId);

}
