package com.diary.calendar.domains;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * <h3>RecordTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class RecordTest {

    /**
     * Constants for tests
     */
    private static final Long ID = 1L;
    private static final Long ID_NEW = 2L;
    private static final DateTime DATETIME = new DateTime(2015, 1, 1, 1, 1, 1);
    private static final DateTime DATETIME_NEW = new DateTime(2016, 2, 2, 2, 2, 2);
    private static final int OPERATIONS_SIZE = 0;
    private static final int OPERATIONS_SIZE_NEW = 2;

    private Record record;

    @Before
    public void init() {
        record = new Record();
        record.setId(ID);
        record.setDate(DATETIME);
        record.setOperations(new ArrayList<Operation>());
        record.setUser(new User());
    }

    @Test
    public void testGetId() {
        assertThat(record.getId()).isEqualTo(ID);
    }

    @Test
    public void testSetId() {
        assertThat(record.getId()).isEqualTo(ID);
        record.setId(ID_NEW);
        assertThat(record.getId()).isEqualTo(ID_NEW);
    }

    @Test
    public void testGetUser() {
        assertThat(record.getUser()).isNotNull();
    }

    @Test
    public void testSetUser() {
        int hash = record.getUser().hashCode();
        record.setUser(new User());
        assertThat(record.getUser().hashCode()).isNotEqualTo(hash);
    }

    @Test
    public void testGetOperations() {
        List<Operation> operations = record.getOperations();
        assertThat(operations).isNotNull();
        assertThat(operations.size()).isEqualTo(OPERATIONS_SIZE);
    }

    @Test
    public void testSetOperations() {
        List<Operation> operations = record.getOperations();
        assertThat(operations).isNotNull();
        assertThat(operations.size()).isEqualTo(OPERATIONS_SIZE);
        operations.add(new Operation());
        operations.add(new Operation());
        record.setOperations(operations);
        operations = record.getOperations();
        assertThat(operations).isNotNull();
        assertThat(operations.size()).isEqualTo(OPERATIONS_SIZE_NEW);
    }

    @Test
    public void testGetDate() {
        assertThat(record.getDate()).isEqualTo(DATETIME);
    }

    @Test
    public void testSetDate() {
        assertThat(record.getDate()).isEqualTo(DATETIME);
        record.setDate(DATETIME_NEW);
        assertThat(record.getDate()).isEqualTo(DATETIME_NEW);
    }

}
