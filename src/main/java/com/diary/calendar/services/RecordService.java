package com.diary.calendar.services;

import com.diary.calendar.domains.Record;
import java.util.List;
import org.joda.time.DateTime;

/**
 * interface RecordService
 *
 * @author Aliaksandr_Padalka
 */
public interface RecordService {

    /**
     * Get all records.
     *
     * @return records
     */
    List<Record> getAllRecord();

    /**
     * Get records by specific <code>date</code>.
     *
     * @param date
     * @return records
     */
    List<Record> getRecordsByDate(DateTime date);

    /**
     * Get record by <code>recordId<code>.
     *
     * @param recordId
     * @return record
     */
    Record getRecordByRecordId(Long recordId);

    /**
     * Save new or update existing <code>record</code>.
     *
     * @param record
     * @return record
     */
    Record saveOrUpdateRecord(Record record);

    /**
     * Delete <code>record</code>.
     *
     * @param record
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteRecord(Record record);

    /**
     * Delete record by <tt>recordId</tt>.
     *
     * @param recordId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteRecord(Long recordId);

}
