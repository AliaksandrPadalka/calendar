package com.diary.calendar.domains;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * <h3>OperationTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class OperationTest {

    /**
     * Constants for tests
     */
    private static final Long ID = 1L;
    private static final Long ID_NEW = 2L;
    private static final String NAME = "name";
    private static final String NAME_NEW = "new name";
    private static final String DESCRIPTION = "description";
    private static final String DESCRIPTION_NEW = "new description";
    private static final Double DURATION = 1.5D;
    private static final Double DURATION_NEW = 2.5D;
    private static final int RECORDS_SIZE = 0;
    private static final int RECORDS_SIZE_NEW = 2;

    private Operation operation;

    @Before
    public void init() {
        operation = new Operation();
        operation.setId(ID);
        operation.setName(NAME);
        operation.setDescription(DESCRIPTION);
        operation.setDuration(DURATION);
        operation.setRecords(new ArrayList<Record>());
    }

    @Test
    public void testGetId() {
        assertThat(operation.getId()).isEqualTo(ID);
    }

    @Test
    public void testSetId() {
        assertThat(operation.getId()).isEqualTo(ID);
        operation.setId(ID_NEW);
        assertThat(operation.getId()).isEqualTo(ID_NEW);
    }

    @Test
    public void testGetName() {
        assertThat(operation.getName()).isEqualTo(NAME);
    }

    @Test
    public void testSetName() {
        assertThat(operation.getName()).isEqualTo(NAME);
        operation.setName(NAME_NEW);
        assertThat(operation.getName()).isEqualTo(NAME_NEW);
    }

    @Test
    public void testGetDescription() {
        assertThat(operation.getDescription()).isEqualTo(DESCRIPTION);
    }

    @Test
    public void testSetDescription() {
        assertThat(operation.getDescription()).isEqualTo(DESCRIPTION);
        operation.setDescription(DESCRIPTION_NEW);
        assertThat(operation.getDescription()).isEqualTo(DESCRIPTION_NEW);
    }

    @Test
    public void testGetDuration() {
        assertThat(operation.getDuration()).isEqualTo(DURATION);
    }

    @Test
    public void testSetDuration() {
        assertThat(operation.getDuration()).isEqualTo(DURATION);
        operation.setDuration(DURATION_NEW);
        assertThat(operation.getDuration()).isEqualTo(DURATION_NEW);
    }

    @Test
    public void testGetRecord() {
        List<Record> records = operation.getRecords();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(RECORDS_SIZE);
    }

    @Test
    public void testSetRecord() {
        List<Record> records = operation.getRecords();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(RECORDS_SIZE);
        records.add(new Record());
        records.add(new Record());
        operation.setRecords(records);
        records = operation.getRecords();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(RECORDS_SIZE_NEW);
    }

}
