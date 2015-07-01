package com.diary.calendar.services;

import com.diary.calendar.domains.Phone;
import java.util.List;

public interface PhoneService {

    List<Phone> getAllPhones();

    List<Phone> getPhonesByUserId(Long phoneId);

    Phone getPhoneByPhoneId(Long phoneId);

    Phone saveOrUpdatePhone(Phone phone);

    boolean deletePhone(Phone phone);

    boolean deletePhone(Long phoneId);
}
