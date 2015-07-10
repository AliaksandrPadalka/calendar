package com.diary.calendar;

/**
 * <h3>Class of constants</h3>
 *
 * @author Aliaksandr_Padalka
 */
public final class Constants {

    /**
     * instance Access
     */
    private final Access access;
    /**
     * instance Pages
     */
    private final Pages pages;
    /**
     * instance Time
     */
    private final Time time;

    /**
     * <h3>Constructor.</h3>
     */
    private Constants() {
        access = new Access();
        pages = new Pages();
        time = new Time();
    }

    /**
     * Get instance Constants class
     *
     * @return time
     */
    public static Constants getInstance() {
        return new Constants();
    }

    /**
     * Get instance Access class
     *
     * @return access
     */
    public Access getInstanceAccess() {
        return access;
    }

    /**
     * Get instance Pages class
     *
     * @return pages
     */
    public Pages getInstancePages() {
        return pages;
    }

    /**
     * Get instance Time class
     *
     * @return time
     */
    public Time getInstanceTime() {
        return time;
    }

    /**
     * <h3>Constants of user access</h3>
     */
    public final class Access {

        /**
         * <h3>Constant ANONIMOUS</h3>
         */
        public static final String ANONIMOUS = "ANONIMOUS";

        /**
         * <h3>Constructor.</h3>
         */
        private Access() {
        }

    }

    /**
     * <h3>Constants of page names</h3>
     */
    public final class Pages {

        /**
         * <h3>Constant URL_PAGE_HELLO</h3>
         */
        public static final String URL_PAGE_HELLO = "hello";
        /**
         * <h3>Constant URL_PAGE_403</h3>
         */
        public static final String URL_PAGE_403 = "403";
        /**
         * <h3>Constant URL_PAGE_ADMIN</h3>
         */
        public static final String URL_PAGE_ADMIN = "admin";
        /**
         * <h3>Constant URL_PAGE_ERROR</h3>
         */
        public static final String URL_PAGE_ERROR = "error";
        /**
         * <h3>Constant URL_PAGE_LOGIN</h3>
         */
        public static final String URL_PAGE_LOGIN = "login";

        /**
         * <h3>Constructor.</h3>
         */
        private Pages() {
        }

    }

    /**
     * <h3>Constants of time</h3>
     */
    public final class Time {

        /**
         * <h3>Constant HOUR_0</h3>
         */
        public static final int HOUR_0 = 0;
        /**
         * <h3>Constant HOUR_23</h3>
         */
        public static final int HOUR_23 = 23;

        /**
         * <h3>Constant MINUTE_0</h3>
         */
        public static final int MINUTE_0 = 0;
        /**
         * <h3>Constant MINUTE_59</h3>
         */
        public static final int MINUTE_59 = 59;

        /**
         * <h3>Constant SECUNDA_0</h3>
         */
        public static final int SECUNDA_0 = 0;
        /**
         * <h3>Constant SECUNDA_59</h3>
         */
        public static final int SECUNDA_59 = 59;

        /**
         * <h3>Constructor.</h3>
         */
        private Time() {
        }

    }

}
