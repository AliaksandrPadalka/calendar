package com.diary.calendar.services;

import com.diary.calendar.domains.Record;
import java.util.List;
import org.joda.time.DateTime;

public interface RecordService {

    List<Record> getAllRecord();

    List<Record> getRecordsByDate(DateTime date);

    Record getRecordByRecordId(Long recordId);

    Record saveOrUpdateRecord(Record record);

    boolean deleteRecord(Record record);

    boolean deleteRecord(Long recordId);
}
