package org.euler.problems;

import static org.euler.util.MyCalendar.DAY;
import static org.euler.util.MyCalendar.MONTH;

public class Problem19 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        DAY given = DAY.MONDAY;
        DAY start = addYear(given, 1900);
        System.out.println(start);
        int totalSundays = 0;
        int totalDays = 0;
        for (int year = 1901; year < 2001; year++) {
            for (MONTH month : MONTH.values()) {
                totalDays += month.getDaysCnt(year);
                if (start.plusDays(totalDays) == DAY.SUNDAY) {
                    totalSundays++;
                }
            }

        }

        System.out.println(totalSundays);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static DAY addYear(DAY start, int year) {
        int totalDays = 0;
        for (MONTH month : MONTH.values()) {
            totalDays += month.getDaysCnt(year);
        }
        return start.plusDays(totalDays);
    }

}
