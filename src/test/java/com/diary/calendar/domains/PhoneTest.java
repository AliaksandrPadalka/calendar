package com.diary.calendar.domains;

import com.diary.calendar.enums.PhoneType;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 * <h3>PhoneTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class PhoneTest {

    /**
     * Constants for tests
     */
    private static final Long ID = 1L;
    private static final Long ID_NEW = 2L;
    private static final PhoneType PHONETYPE = PhoneType.HOME_PHONE;
    private static final PhoneType PHONETYPE_NEW = PhoneType.MOBILE_PHONE;
    private static final String NUMBER = "number";
    private static final String NUMBER_NEW = "new number";
    private static final String CODE = "code";
    private static final String CODE_NEW = "new code";

    private Phone phone;

    @Before
    public void init() {
        phone = new Phone();
        phone.setId(ID);
        phone.setCode(CODE);
        phone.setNumber(NUMBER);
        phone.setType(PHONETYPE);
        phone.setUser(new User());
    }

    @Test
    public void testGetId() {
        assertThat(phone.getId()).isEqualTo(ID);
    }

    @Test
    public void testSetId() {
        assertThat(phone.getId()).isEqualTo(ID);
        phone.setId(ID_NEW);
        assertThat(phone.getId()).isEqualTo(ID_NEW);
    }

    @Test
    public void testGetType() {
        assertThat(phone.getType()).isEqualTo(PHONETYPE);
    }

    @Test
    public void testSetType() {
        assertThat(phone.getType()).isEqualTo(PHONETYPE);
        phone.setType(PHONETYPE_NEW);
        assertThat(phone.getType()).isEqualTo(PHONETYPE_NEW);
    }

    @Test
    public void testGetCode() {
        assertThat(phone.getCode()).isEqualTo(CODE);
    }

    @Test
    public void testSetCode() {
        assertThat(phone.getCode()).isEqualTo(CODE);
        phone.setCode(CODE_NEW);
        assertThat(phone.getCode()).isEqualTo(CODE_NEW);
    }

    @Test
    public void testGetNumber() {
        assertThat(phone.getNumber()).isEqualTo(NUMBER);
    }

    @Test
    public void testSetNumber() {
        assertThat(phone.getNumber()).isEqualTo(NUMBER);
        phone.setNumber(NUMBER_NEW);
        assertThat(phone.getNumber()).isEqualTo(NUMBER_NEW);
    }

    @Test
    public void testGetUser() {
        assertThat(phone.getUser()).isNotNull();
    }

    @Test
    public void testSetUser() {
        int hash = phone.getUser().hashCode();
        phone.setUser(new User());
        assertThat(phone.getUser().hashCode()).isNotEqualTo(hash);
    }

}
