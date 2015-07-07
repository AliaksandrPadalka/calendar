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
 *
 * @author Aliaksandr_Padalka
 */
public class PhoneServiceImpl implements PhoneService {

    private static final Logger LOG = Logger.getLogger(PhoneServiceImpl.class.getName());

    @Autowired
    private PhoneRepository repository;

    /**
     *
     * @return
     */
    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phones = new ArrayList<>();
        phones.addAll((Collection<? extends Phone>) repository.findAll());
        return phones;
    }

    /**
     *
     * @param userId
     * @return
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
     *
     * @param phoneId
     * @return
     */
    @Override
    public Phone getPhoneByPhoneId(final Long phoneId) {
        return repository.findOne(phoneId);
    }

    /**
     *
     * @param phone
     * @return
     */
    @Override
    public Phone saveOrUpdatePhone(final Phone phone) {
        return repository.save(phone);
    }

    /**
     *
     * @param phone
     * @return
     */
    @Override
    public boolean deletePhone(final Phone phone) {
        return deletePhone(phone.getId());
    }

    /**
     *
     * @param phoneId
     * @return
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
