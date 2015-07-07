package com.diary.calendar.services;

import com.diary.calendar.domains.Phone;
import java.util.List;

/**
 * interface PhoneService
 *
 * @author Aliaksandr_Padalka
 */
public interface PhoneService {

    /**
     * Get all phones.
     *
     * @return phones
     */
    List<Phone> getAllPhones();

    /**
     * Get all phones by <code>userId</code>.
     *
     * @param userId
     * @return phones
     */
    List<Phone> getPhonesByUserId(Long userId);

    /**
     * Get phone by <code>phoneId</code>.
     *
     * @param phoneId
     * @return phone
     */
    Phone getPhoneByPhoneId(Long phoneId);

    /**
     * Save new or update existing <code>phone</code>.
     *
     * @param phone
     * @return phone
     */
    Phone saveOrUpdatePhone(Phone phone);

    /**
     * Delete <code>phone</code>.
     *
     * @param phone
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deletePhone(Phone phone);

    /**
     * Delete phone by <code>phoneId</code>.
     *
     * @param phoneId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deletePhone(Long phoneId);
}
