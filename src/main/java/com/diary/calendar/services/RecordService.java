package com.diary.calendar.services;

import com.diary.calendar.domains.Record;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author Aliaksandr_Padalka
 */
public interface RecordService {

    /**
     *
     * @return
     */
    List<Record> getAllRecord();

    /**
     *
     * @param date
     * @return
     */
    List<Record> getRecordsByDate(DateTime date);

    /**
     *
     * @param recordId
     * @return
     */
    Record getRecordByRecordId(Long recordId);

    /**
     *
     * @param record
     * @return
     */
    Record saveOrUpdateRecord(Record record);

    /**
     *
     * @param record
     * @return
     */
    boolean deleteRecord(Record record);

    /**
     *
     * @param recordId
     * @return
     */
    boolean deleteRecord(Long recordId);
}
