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

public class RecordServiceImpl implements RecordService {

    private static final Logger LOG = Logger.getLogger(RecordServiceImpl.class.getName());

    @Autowired
    private RecordRepository repository;

    @Override
    public List<Record> getAllRecord() {
        List<Record> records = new ArrayList<>();
        records.addAll((Collection<? extends Record>) repository.findAll());
        return records;
    }

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

    @Override
    public Record getRecordByRecordId(final Long recordId) {
        return repository.findOne(recordId);
    }

    @Override
    public Record saveOrUpdateRecord(final Record record) {
        return repository.save(record);
    }

    @Override
    public boolean deleteRecord(final Record record) {
        return deleteRecord(record.getId());
    }

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
