package com.diary.calendar.domains;

import com.diary.calendar.enums.UserRole;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * <h3>UserTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class UserTest {

    /**
     * Constants for tests
     */
    private static final Long ID = 1L;
    private static final Long ID_NEW = 2L;
    private static final String NAME = "name";
    private static final String NAME_NEW = "new name";
    private static final int PHONES_SIZE = 0;
    private static final int PHONES_SIZE_NEW = 2;
    private static final int RECORDS_SIZE = 0;
    private static final int RECORDS_SIZE_NEW = 2;
    private static final UserRole USERROLE = UserRole.USER;
    private static final UserRole USERROLE_NEW = UserRole.OWNER;

    private User user;

    @Before
    public void init() {
        user = new User();
        user.setId(ID);
        user.setName(NAME);
        user.setPhones(new ArrayList<Phone>());
        user.setRecords(new ArrayList<Record>());
        user.setRole(USERROLE);
    }

    @Test
    public void testGetId() {
        assertThat(user.getId()).isEqualTo(ID);
    }

    @Test
    public void testSetId() {
        assertThat(user.getId()).isEqualTo(ID);
        user.setId(ID_NEW);
        assertThat(user.getId()).isEqualTo(ID_NEW);
    }

    @Test
    public void testGetName() {
        assertThat(user.getName()).isEqualTo(NAME);
    }

    @Test
    public void testSetName() {
        assertThat(user.getName()).isEqualTo(NAME);
        user.setName(NAME_NEW);
        assertThat(user.getName()).isEqualTo(NAME_NEW);
    }

    @Test
    public void testGetPhones() {
        List<Phone> phones = user.getPhones();
        assertThat(phones).isNotNull();
        assertThat(phones.size()).isEqualTo(PHONES_SIZE);
    }

    @Test
    public void testSetPhones() {
        List<Phone> phones = user.getPhones();
        assertThat(phones).isNotNull();
        assertThat(phones.size()).isEqualTo(PHONES_SIZE);
        phones.add(new Phone());
        phones.add(new Phone());
        user.setPhones(phones);
        phones = user.getPhones();
        assertThat(phones).isNotNull();
        assertThat(phones.size()).isEqualTo(PHONES_SIZE_NEW);
    }

    @Test
    public void testGetRole() {
        assertThat(user.getRole()).isEqualTo(USERROLE);
    }

    @Test
    public void testSetRole() {
        assertThat(user.getRole()).isEqualTo(USERROLE);
        user.setRole(USERROLE_NEW);
        assertThat(user.getRole()).isEqualTo(USERROLE_NEW);
    }

    @Test
    public void testGetRecords() {
        List<Record> records = user.getRecords();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(RECORDS_SIZE);
    }

    @Test
    public void testSetRecords() {
        List<Record> records = user.getRecords();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(RECORDS_SIZE);
        records.add(new Record());
        records.add(new Record());
        user.setRecords(records);
        records = user.getRecords();
        assertThat(records).isNotNull();
        assertThat(records.size()).isEqualTo(RECORDS_SIZE_NEW);
    }

}
