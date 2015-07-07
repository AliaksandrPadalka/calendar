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
 * class PhoneServiceImpl implements interface {@link PhoneService}
 *
 * @author Aliaksandr_Padalka
 */
public class PhoneServiceImpl implements PhoneService {

    private static final Logger LOG = Logger.getLogger(PhoneServiceImpl.class.getName());

    @Autowired
    private PhoneRepository repository;

    /**
     * Get all phones.
     *
     * @return phones
     */
    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.addAll((Collection<? extends Phone>) repository.findAll());
        return phones;
    }

    /**
     * Get all phones by <code>userId</code>.
     *
     * @param userId
     * @return phones
     */
    @Override
    public List<Phone> getPhonesByUserId(final Long userId) {
        List<Phone> phones = getAllPhones();

        for (Phone phone : phones) {
            if (!userId.equals(phone.getUser().getId())) {
                phones.remove(phone);
            }
        }

        return phones;
    }

    /**
     * Get phone by <code>phoneId</code>.
     *
     * @param phoneId
     * @return phone
     */
    @Override
    public Phone getPhoneByPhoneId(final Long phoneId) {
        return repository.findOne(phoneId);
    }

    /**
     * Save new or update existing <code>phone</code>.
     *
     * @param phone
     * @return phone
     */
    @Override
    public Phone saveOrUpdatePhone(final Phone phone) {
        return repository.save(phone);
    }

    /**
     * Delete <code>phone</code>.
     *
     * @param phone
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public boolean deletePhone(final Phone phone) {
        return deletePhone(phone.getId());
    }

    /**
     * Delete phone by <code>phoneId</code>.
     *
     * @param phoneId
     * @return <code>true</code> else if exception return <code>false</code>
     */
    @Override
    public boolean deletePhone(final Long phoneId) {
        try {
            repository.delete(phoneId);
            return true;
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }
        return false;
    }

}
