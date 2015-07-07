/**
 * <p>
 * License
 * </p>
 */
package com.diary.calendar.services.impl;

/**
 * <p>
 * Imports
 * </p>
 */
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

    private static final Logger LOG = Logger.getLogger(RecordServiceImpl.class.getName());

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
     * @param date
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
     * <h3>Get record by <code>recordId</code>.</h3>
     *
     * @param recordId
     * @return record
     */
    @Override
    public final Record getRecordByRecordId(final Long recordId) {
        return repository.findOne(recordId);
    }

    /**
     * <h3>Save new or update existing <code>record</code>.</h3>
     *
     * @param record
     * @return record
     */
    @Override
    public final Record saveOrUpdateRecord(final Record record) {
        return repository.save(record);
    }

    /**
     * <h3>Delete <code>record</code>.</h3>
     *
     * @param record
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deleteRecord(final Record record) {
        return deleteRecord(record.getId());
    }

    /**
     * <h3>Delete record by <code>recordId</code>.</h3>
     *
     * @param recordId
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
