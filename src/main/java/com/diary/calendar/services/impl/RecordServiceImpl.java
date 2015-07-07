package com.diary.calendar.services.impl;

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
 * class RecordServiceImpl implements interface {@link RecordService}
 *
 * @author Aliaksandr_Padalka
 */
public class RecordServiceImpl implements RecordService {

    private static final Logger LOG = Logger.getLogger(RecordServiceImpl.class.getName());

    @Autowired
    private RecordRepository repository;

    /**
     * Get all records.
     *
     * @return records
     */
    @Override
    public List<Record> getAllRecord() {
        List<Record> records = new ArrayList<>();
        records.addAll((Collection<? extends Record>) repository.findAll());
        return records;
    }

    /**
     * Get records by specific <code>date</code>.
     *
     * @param date
     * @return records
     */
    @Override
    public List<Record> getRecordsByDate(final DateTime date) {
        List<Record> records = getAllRecord();

        for (Iterator<Record> iterator = records.iterator(); iterator.hasNext();) {
            Record record = iterator.next();
            if (isOutDate(record, date)) {
                iterator.remove();
            }
        }

        return records;
    }

    private static boolean isOutDate(final Record record, final DateTime date) {
        DateTime startDate = new DateTime()
                .withYear(date.getYear())
                .withMonthOfYear(date.getMonthOfYear())
                .withDayOfMonth(date.getDayOfMonth())
                .withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0);
        DateTime endDate = new DateTime()
                .withYear(date.getYear())
                .withMonthOfYear(date.getMonthOfYear())
                .withDayOfMonth(date.getDayOfMonth())
                .withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59);
        return record.getDate().isBefore(startDate.toInstant()) || record.getDate().isAfter(endDate.toInstant());
    }

    /**
     * Get record by <code>recordId</code>.
     *
     * @param recordId
     * @return record
     */
    @Override
    public Record getRecordByRecordId(final Long recordId) {
        return repository.findOne(recordId);
    }

    /**
     * Save new or update existing <code>record</code>.
     *
     * @param record
     * @return record
     */
    @Override
    public Record saveOrUpdateRecord(final Record record) {
        return repository.save(record);
    }

    /**
     * Delete <code>record</code>.
     *
     * @param record
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public boolean deleteRecord(final Record record) {
        return deleteRecord(record.getId());
    }

    /**
     * Delete record by <tt>recordId</tt>.
     *
     * @param recordId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public boolean deleteRecord(final Long recordId) {
        try {
            repository.delete(recordId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }

}
