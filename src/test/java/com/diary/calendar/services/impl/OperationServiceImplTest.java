package com.diary.calendar.services.impl;

import com.diary.calendar.domains.Operation;
import com.diary.calendar.repositories.OperationRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * <h3>OperationServiceImplTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
@RunWith(MockitoJUnitRunner.class)
public class OperationServiceImplTest {

    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 1L;
    private static final String NAME = "name";
    private static final String NAME_NEW = "new name";

    @Mock
    private OperationRepository repo;

    @InjectMocks
    private OperationServiceImpl service;

    private Operation oper1;
    private Operation oper2;
    private Operation oper1_new;
    private Operation oper2_new;

    @Before
    public void init() {
        oper1 = new Operation();
        oper1.setId(ID_1);
        oper1.setName(NAME);
        oper2 = new Operation();
        oper2.setId(ID_2);
        oper2.setName(NAME);

        List<Operation> operations = new ArrayList<>(Arrays.asList(oper1, oper2));

        oper1_new = new Operation();
        oper1_new.setName(NAME);

        oper2_new = new Operation();
        oper2_new.setId(ID_2);
        oper2_new.setName(NAME_NEW);

        when(repo.findAll()).thenReturn(operations);
        when(repo.findOne(ID_1)).thenReturn(oper1);
        when(repo.save(oper1_new)).thenReturn(oper1);
        when(repo.save(oper2_new)).thenReturn(oper2_new);
    }

    @Test
    public void testGetAllOperations() {
        List<Operation> operations = service.getAllOperations();
        assertThat(operations).isNotNull();
        assertThat(operations.size()).isEqualTo(2);
    }

    @Test
    public void testGetOperationByOperationId() {
        Operation oper = service.getOperationByOperationId(ID_1);
        assertThat(oper).isNotNull();
        assertThat(oper.getId()).isEqualTo(ID_1);
        assertThat(oper.getName()).isEqualTo(NAME);
    }

    @Test
    public void testSaveOrUpdateOperation() {
        Operation saved_oper1 = service.saveOrUpdateOperation(oper1_new);
        assertThat(saved_oper1).isNotNull();
        assertThat(saved_oper1.getId()).isEqualTo(ID_1);
        assertThat(saved_oper1.getName()).isEqualTo(NAME);

        Operation saved_oper2 = service.saveOrUpdateOperation(oper2_new);
        assertThat(saved_oper2).isNotNull();
        assertThat(saved_oper2.getId()).isEqualTo(ID_2);
        assertThat(saved_oper2.getName()).isEqualTo(NAME_NEW);
    }

    @Test
    public void testDeleteOperation_Operation() {
        boolean flag = service.deleteOperation(oper1);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeleteOperation_Long() {
        boolean flag = service.deleteOperation(ID_1);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeleteOperation_IllegalArgumentException() {
        doThrow(new IllegalArgumentException()).when(repo).delete(ID_1);
        boolean flag = service.deleteOperation(ID_1);
        assertThat(flag).isEqualTo(false);
    }

}
