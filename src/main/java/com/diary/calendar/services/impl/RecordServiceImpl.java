package com.diary.calendar.services.impl;

import com.diary.calendar.Constants;
import com.diary.calendar.domains.Record;
import com.diary.calendar.repositories.RecordRepository;
import com.diary.calendar.services.RecordService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h3>class RecordServiceImpl implements interface {@link RecordService}</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class RecordServiceImpl implements RecordService {

    /**
     * <code>Logger</code>
     */
    private static final Logger LOG = Logger.getLogger(RecordServiceImpl.class.getName());

    /**
     * <code>RecordRepository bean</code>
     */
    @Autowired
    private RecordRepository repository;

    /**
     * <h3>Get all records.</h3>
     *
     * @return records
     */
    @Override
    public final List<Record> getAllRecord() {
        List<Record> records = new ArrayList<>();
        records.addAll((Collection<? extends Record>) repository.findAll());
        return records;
    }

    /**
     * <h3>Get records by specific <code>date</code>.</h3>
     *
     * @param date as DateTime
     * @return records
     */
    @Override
    public final List<Record> getRecordsByDate(final DateTime date) {
        List<Record> records = getAllRecord();

        for (Iterator<Record> iterator = records.iterator(); iterator.hasNext();) {
            Record record = iterator.next();
            if (isOutDate(record, date)) {
                iterator.remove();
            }
        }

        return records;
    }

    /**
     * <h3>Utility method</h3>
     *
     * @param record as Record
     * @param date as DateTime
     * @return <code>true</code> if date does not belong to this day else <code>false</code> if date belongs to this day
     */
    private static boolean isOutDate(final Record record, final DateTime date) {
        DateTime startDate = new DateTime()
                .withYear(date.getYear())
                .withMonthOfYear(date.getMonthOfYear())
                .withDayOfMonth(date.getDayOfMonth())
                .withHourOfDay(Constants.Time.HOUR_0)
                .withMinuteOfHour(Constants.Time.MINUTE_0)
                .withSecondOfMinute(Constants.Time.SECUNDA_0);
        DateTime endDate = new DateTime()
                .withYear(date.getYear())
                .withMonthOfYear(date.getMonthOfYear())
                .withDayOfMonth(date.getDayOfMonth())
                .withHourOfDay(Constants.Time.HOUR_23)
                .withMinuteOfHour(Constants.Time.MINUTE_59)
                .withSecondOfMinute(Constants.Time.SECUNDA_59);
        return record.getDate().isBefore(startDate.toInstant()) || record.getDate().isAfter(endDate.toInstant());
    }

    /**
     * <h3>Get record by <code>recordId</code>.</h3>
     *
     * @param recordId as Long
     * @return record
     */
    @Override
    public final Record getRecordByRecordId(final Long recordId) {
        return repository.findOne(recordId);
    }

    /**
     * <h3>Save new or update existing <code>record</code>.</h3>
     *
     * @param record as Record
     * @return record
     */
    @Override
    public final Record saveOrUpdateRecord(final Record record) {
        return repository.save(record);
    }

    /**
     * <h3>Delete <code>record</code>.</h3>
     *
     * @param record as Record
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteRecord(final Record record) {
        return deleteRecord(record.getId());
    }

    /**
     * <h3>Delete record by <code>recordId</code>.</h3>
     *
     * @param recordId as Long
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteRecord(final Long recordId) {
        try {
            repository.delete(recordId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }

}
