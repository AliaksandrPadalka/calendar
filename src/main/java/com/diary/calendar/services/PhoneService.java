package com.diary.calendar.services;

import com.diary.calendar.domains.Phone;
import java.util.List;

/**
 *
 * @author Aliaksandr_Padalka
 */
public interface PhoneService {

    /**
     *
     * @return
     */
    List<Phone> getAllPhones();

    /**
     *
     * @param phoneId
     * @return
     */
    List<Phone> getPhonesByUserId(Long phoneId);

    /**
     *
     * @param phoneId
     * @return
     */
    Phone getPhoneByPhoneId(Long phoneId);

    /**
     *
     * @param phone
     * @return
     */
    Phone saveOrUpdatePhone(Phone phone);

    /**
     *
     * @param phone
     * @return
     */
    boolean deletePhone(Phone phone);

    /**
     *
     * @param phoneId
     * @return
     */
    boolean deletePhone(Long phoneId);
}
