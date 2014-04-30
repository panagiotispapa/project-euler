package org.euler.util;

import com.google.common.collect.Maps;

import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

public class MyCalendar {
    public enum DAY {
        MONDAY(0),
        TUESDAY(1),
        WENSDAY(2),
        THIRSDAY(3),
        FRIDAY(4),
        SATTURDAY(5),
        SUNDAY(6);

        private static final Map<Integer, DAY> mapById;
        private final int id;

        static {
            mapById = Maps.newHashMap();
            for (DAY day : DAY.values()) {
                mapById.put(day.getId(), day);
            }

        }

        private DAY(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public DAY fromId(int id) {
            checkState(id >= MONDAY.getId() && id <= SUNDAY.getId());
            return mapById.get(id);
        }

        public DAY plusDays(int days) {
            return fromId((id + days) % 7);
        }
    }

    public enum MONTH {
        JANUARY(31),
        FEB(28),
        MARTS(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPT(30),
        OCT(31),
        NOV(30),
        DEC(31);

        private final int daysCnt;

        private MONTH(int daysCnt) {
            this.daysCnt = daysCnt;
        }

        public int getDaysCnt(int year) {
            if (this == FEB) {
                return isLeapYear(year) ? 29 : daysCnt;
            } else {
                return daysCnt;
            }

        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
