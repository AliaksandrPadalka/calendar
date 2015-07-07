package com.diary.calendar.services.impl;

import com.diary.calendar.domains.Phone;
import com.diary.calendar.repositories.PhoneRepository;
import com.diary.calendar.services.PhoneService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <h3>class PhoneServiceImpl implements interface {@link PhoneService}</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class PhoneServiceImpl implements PhoneService {

    /**
     * <code>Logger</code>
     */
    private static final Logger LOG = Logger.getLogger(PhoneServiceImpl.class.getName());

    /**
     * <code>PhoneRepository bean</code>
     */
    @Autowired
    private PhoneRepository repository;

    /**
     * <h3>Get all phones.</h3>
     *
     * @return phones
     */
    @Override
    public final List<Phone> getAllPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.addAll((Collection<? extends Phone>) repository.findAll());
        return phones;
    }

    /**
     * <h3>Get all phones by <code>userId</code>.</h3>
     *
     * @param userId as Long
     * @return phones
     */
    @Override
    public final List<Phone> getPhonesByUserId(final Long userId) {
        List<Phone> phones = getAllPhones();

        for (Phone phone : phones) {
            if (!userId.equals(phone.getUser().getId())) {
                phones.remove(phone);
            }
        }

        return phones;
    }

    /**
     * <h3>Get phone by <code>phoneId</code>.</h3>
     *
     * @param phoneId as Long
     * @return phone
     */
    @Override
    public final Phone getPhoneByPhoneId(final Long phoneId) {
        return repository.findOne(phoneId);
    }

    /**
     * <h3>Save new or update existing <code>phone</code>.</h3>
     *
     * @param phone as Phone
     * @return phone
     */
    @Override
    public final Phone saveOrUpdatePhone(final Phone phone) {
        return repository.save(phone);
    }

    /**
     * <h3>Delete <code>phone</code>.</h3>
     *
     * @param phone as Phone
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deletePhone(final Phone phone) {
        return deletePhone(phone.getId());
    }

    /**
     * <h3>Delete phone by <code>phoneId</code>.</h3>
     *
     * @param phoneId as Long
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public final boolean deletePhone(final Long phoneId) {
        try {
            repository.delete(phoneId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }

}
