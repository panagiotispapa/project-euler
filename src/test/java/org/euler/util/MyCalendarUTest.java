package org.euler.util;

import org.junit.Test;

import static org.euler.util.MyCalendar.DAY.*;
import static org.euler.util.MyCalendar.isLeapYear;
import static org.fest.assertions.api.Assertions.assertThat;

public class MyCalendarUTest {

    @Test
    public void testDay() throws Exception {
        assertThat(MONDAY.plusDays(1)).isEqualTo(TUESDAY);
        assertThat(MONDAY.plusDays(2)).isEqualTo(WENSDAY);
        assertThat(MONDAY.plusDays(7)).isEqualTo(MONDAY);
    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertThat(isLeapYear(1804)).isTrue();
        assertThat(isLeapYear(1805)).isFalse();
        assertThat(isLeapYear(1900)).isFalse();
        assertThat(isLeapYear(2400)).isTrue();
    }

    @Test
    public void testMonth() throws Exception {
        assertThat(MyCalendar.MONTH.JANUARY.getDaysCnt(1200)).isEqualTo(31);
        assertThat(MyCalendar.MONTH.FEB.getDaysCnt(1900)).isEqualTo(28);
        assertThat(MyCalendar.MONTH.FEB.getDaysCnt(2400)).isEqualTo(29);
        assertThat(MyCalendar.MONTH.MARTS.getDaysCnt(2400)).isEqualTo(31);

    }
}
