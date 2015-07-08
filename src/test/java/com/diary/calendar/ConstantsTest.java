package com.diary.calendar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

/**
 * <h3>ConstantsTest</h3>
 *
 * @author Aliaksandr_Padalka
 */
public class ConstantsTest {

    @Test
    public void test() {
        assertThat(Constants.Access.ANONIMOUS).isEqualTo("ANONIMOUS");

        assertThat(Constants.Pages.URL_PAGE_403).isEqualTo("403");
        assertThat(Constants.Pages.URL_PAGE_ADMIN).isEqualTo("admin");
        assertThat(Constants.Pages.URL_PAGE_ERROR).isEqualTo("error");
        assertThat(Constants.Pages.URL_PAGE_HELLO).isEqualTo("hello");

        assertThat(Constants.Time.HOUR_0).isEqualTo(0);
        assertThat(Constants.Time.HOUR_23).isEqualTo(23);
        assertThat(Constants.Time.MINUTE_0).isEqualTo(0);
        assertThat(Constants.Time.MINUTE_59).isEqualTo(59);
        assertThat(Constants.Time.SECUNDA_0).isEqualTo(0);
        assertThat(Constants.Time.SECUNDA_59).isEqualTo(59);
    }

    @Test
    public void testGetInstanceConstant() {
        Constants clazz = Constants.getInstance();
        assertThat(clazz).isNotNull();
    }

    @Test
    public void testGetInstanceAccess() {
        Constants.Access clazz = Constants.getInstance().getInstanceAccess();
        assertThat(clazz).isNotNull();
    }

    @Test
    public void testGetInstancePages() {
        Constants.Pages clazz = Constants.getInstance().getInstancePages();
        assertThat(clazz).isNotNull();
    }

    @Test
    public void testGetInstanceTime() {
        Constants.Time clazz = Constants.getInstance().getInstanceTime();
        assertThat(clazz).isNotNull();
    }

}
