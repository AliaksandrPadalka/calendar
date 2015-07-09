package com.diary.calendar.services.impl;

import com.diary.calendar.domains.Phone;
import com.diary.calendar.domains.User;
import com.diary.calendar.repositories.PhoneRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * <h3>PhoneServiceImplTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceImplTest {

    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 2L;
    private static final Long ID_3 = 3L;
    private static final String CODE = "code";
    private static final String CODE_NEW = "new code";

    @Mock
    private PhoneRepository repo;

    @InjectMocks
    private PhoneServiceImpl service;

    private Phone phone1;
    private Phone phone2;
    private Phone phone3;
    private Phone phone1_new;
    private Phone phone2_new;

    @Before
    public void init() {
        User user1 = new User();
        user1.setId(ID_1);
        User user2 = new User();
        user2.setId(ID_2);

        phone1 = new Phone();
        phone1.setId(ID_1);
        phone1.setCode(CODE);
        phone1.setUser(user1);

        phone2 = new Phone();
        phone2.setId(ID_2);
        phone2.setCode(CODE);
        phone2.setUser(user2);

        phone3 = new Phone();
        phone3.setId(ID_3);
        phone3.setCode(CODE);
        phone3.setUser(user1);

        List<Phone> phones = new ArrayList<>(Arrays.asList(phone1, phone2, phone3));

        phone1_new = new Phone();
        phone1_new.setCode(CODE_NEW);
        phone1_new.setUser(user1);

        phone2_new = new Phone();
        phone2_new.setId(ID_2);
        phone2_new.setCode(CODE_NEW);
        phone2_new.setUser(user2);

        when(repo.findAll()).thenReturn(phones);
        when(repo.findOne(ID_1)).thenReturn(phone1);
        when(repo.save(phone1_new)).thenReturn(phone1);
        when(repo.save(phone2_new)).thenReturn(phone2_new);
    }

    @Test
    public void testGetAllPhones() {
        List<Phone> phones = service.getAllPhones();
        assertThat(phones).isNotNull();
        assertThat(phones.size()).isEqualTo(3);
    }

    @Test
    public void testGetPhonesByUserId() {
        List<Phone> phones = service.getPhonesByUserId(ID_1);
        assertThat(phones).isNotNull();
        assertThat(phones.size()).isEqualTo(2);
    }

    @Test
    public void testGetPhoneByPhoneId() {
        Phone phone = service.getPhoneByPhoneId(ID_1);
        assertThat(phone).isNotNull();
        assertThat(phone.getId()).isEqualTo(ID_1);
        assertThat(phone.getCode()).isEqualTo(CODE);
    }

    @Test
    public void testSaveOrUpdatePhone() {
        Phone saved_phone1 = service.saveOrUpdatePhone(phone1_new);
        assertThat(saved_phone1).isNotNull();
        assertThat(saved_phone1.getId()).isEqualTo(ID_1);
        assertThat(saved_phone1.getCode()).isEqualTo(CODE);

        Phone saved_phone2 = service.saveOrUpdatePhone(phone2_new);
        assertThat(saved_phone2).isNotNull();
        assertThat(saved_phone2.getId()).isEqualTo(ID_2);
        assertThat(saved_phone2.getCode()).isEqualTo(CODE_NEW);
    }

    @Test
    public void testDeletePhone_Phone() {
        boolean flag = service.deletePhone(phone1);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeletePhone_Long() {
        boolean flag = service.deletePhone(ID_1);
        assertThat(flag).isEqualTo(true);
    }

    @Test
    public void testDeletePhone_IllegalArgumentException() {
        doThrow(new IllegalArgumentException()).when(repo).delete(ID_1);
        boolean flag = service.deletePhone(ID_1);
        assertThat(flag).isEqualTo(false);
    }
}
