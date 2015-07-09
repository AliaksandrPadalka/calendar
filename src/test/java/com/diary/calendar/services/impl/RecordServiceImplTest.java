package com.diary.calendar.services.impl;

import com.diary.calendar.domains.Record;
import com.diary.calendar.repositories.RecordRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * <h3>RecordServiceImplTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
@RunWith(MockitoJUnitRunner.class)
public class RecordServiceImplTest {

    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 2L;
    private static final Long ID_3 = 3L;
    private static final Long ID_4 = 4L;

    @Mock
    private RecordRepository repo;

    @InjectMocks
    private RecordServiceImpl service;

    private Record rec1;
    private Record rec2;
    private Record rec3;
    private Record rec4;
    private Record rec1_new;
    private Record rec2_new;
    private DateTime date1;
    private DateTime date2;
    private DateTime date3;
    private DateTime date_new;

    @Before
    public void init() {
        date1 = new DateTime(2015, 1, 1, 1, 1, 1);
        date2 = new DateTime(2015, 2, 1, 1, 1, 1);
        date3 = new DateTime(2015, 3, 1, 1, 1, 1);
        date_new = new DateTime(2015, 4, 1, 1, 1, 1);

        rec1 = new Record();
        rec1.setId(ID_1);
        rec1.setDate(date2);

        rec2 = new Record();
        rec2.setId(ID_2);
        rec2.setDate(date1);

        rec3 = new Record();
        rec3.setId(ID_3);
        rec3.setDate(date2);

        rec4 = new Record();
        rec4.setId(ID_4);
        rec4.setDate(date3);

        List<Record> records = new ArrayList<>(Arrays.asList(rec1, rec2, rec3, rec4));

        rec1_new = new Record();
        rec1_new.setDate(date1);

        rec2_new = new Record();
        rec2_new.setId(ID_2);
        rec2_new.setDate(date_new);

        when(repo.findAll()).thenReturn(records);
        when(repo.findOne(ID_1)).thenReturn(rec1);
        when(repo.save(rec1_new)).thenReturn(rec1);
        when(repo.save(rec2_new)).thenReturn(rec2_new);
    }

    @Test
    public void testGetAllRecord() {
        List<Record> records = service.getAllRecord();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(4);
    }

    @Test
    public void testGetRecordsByDate() {
        List<Record> records = service.getRecordsByDate(date2);
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(2);
    }

    @Test
    public void testGetRecordByRecordId() {
        Record rec = service.getRecordByRecordId(ID_1);
        assertThat(rec).isNotNull();
        assertThat(rec.getId()).isEqualTo(ID_1);
        assertThat(rec.getDate()).isEqualTo(date2);
    }

    @Test
    public void testSaveOrUpdateRecord() {
        Record saved_rec1 = service.saveOrUpdateRecord(rec1_new);
        assertThat(saved_rec1).isNotNull();
        assertThat(saved_rec1.getId()).isEqualTo(ID_1);
        assertThat(saved_rec1.getDate()).isEqualTo(date2);

        Record saved_rec2 = service.saveOrUpdateRecord(rec2_new);
        assertThat(saved_rec2).isNotNull();
        assertThat(saved_rec2.getId()).isEqualTo(ID_2);
        assertThat(saved_rec2.getDate()).isEqualTo(date_new);
    }

    @Test
    public void testDeleteRecord_Record() {
        boolean flag = service.deleteRecord(rec1);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeleteRecord_Long() {
        boolean flag = service.deleteRecord(ID_1);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeletePhone_IllegalArgumentException() {
        doThrow(new IllegalArgumentException()).when(repo).delete(ID_1);
        boolean flag = service.deleteRecord(ID_1);
        assertThat(flag).isEqualTo(false);
    }

}
