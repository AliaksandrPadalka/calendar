package com.diary.calendar.services;

import com.diary.calendar.domains.Record;
import java.util.List;
import org.joda.time.DateTime;

/**
 * <h3>interface RecordService</h3>
 *
 * @author Aliaksandr_Padalka
 */
public interface RecordService {

    /**
     * <h3>Get all records.</h3>
     *
     * @return records
     */
    List<Record> getAllRecord();

    /**
     * <h3>Get records by specific <code>date</code>.</h3>
     *
     * @param date as DateTime
     * @return records
     */
    List<Record> getRecordsByDate(final DateTime date);

    /**
     * <h3>Get record by <code>recordId</code>.</h3>
     *
     * @param recordId as Long
     * @return record
     */
    Record getRecordByRecordId(final Long recordId);

    /**
     * <h3>Save new or update existing <code>record</code>.</h3>
     *
     * @param record as Record
     * @return record
     */
    Record saveOrUpdateRecord(final Record record);

    /**
     * <h3>Delete <code>record</code>.</h3>
     *
     * @param record as Record
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteRecord(final Record record);

    /**
     * <h3>Delete record by <code>recordId</code>.</h3>
     *
     * @param recordId as Long
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deleteRecord(final Long recordId);

}
