package com.diary.calendar.services;

import com.diary.calendar.domains.Phone;
import java.util.List;

/**
 * <h3>interface PhoneService</h3>
 *
 * @author Aliaksandr_Padalka
 */
public interface PhoneService {

    /**
     * <h3>Get all phones.</h3>
     *
     * @return phones
     */
    List<Phone> getAllPhones();

    /**
     * <h3>Get all phones by <code>userId</code>.</h3>
     *
     * @param userId
     * @return phones
     */
    List<Phone> getPhonesByUserId(final Long userId);

    /**
     * <h3>Get phone by <code>phoneId</code>.</h3>
     *
     * @param phoneId
     * @return phone
     */
    Phone getPhoneByPhoneId(final Long phoneId);

    /**
     * <h3>Save new or update existing <code>phone</code>.</h3>
     *
     * @param phone
     * @return phone
     */
    Phone saveOrUpdatePhone(final Phone phone);

    /**
     * <h3>Delete <code>phone</code>.</h3>
     *
     * @param phone
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deletePhone(final Phone phone);

    /**
     * <h3>Delete phone by <code>phoneId</code>.</h3>
     *
     * @param phoneId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    boolean deletePhone(final Long phoneId);
}
