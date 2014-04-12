package org.euler.problems;

import com.google.common.collect.Maps;

import java.util.Map;

import static java.lang.String.format;

public class Problem17 {

    private static final Map<Integer, String> map;

    static {
        map = Maps.newHashMap();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
        map.put(100, "one hundred");
        map.put(200, "two hundred");
        map.put(300, "three hundred");
        map.put(400, "four hundred");
        map.put(500, "five hundred");
        map.put(600, "six hundred");
        map.put(700, "seven hundred");
        map.put(800, "eight hundred");
        map.put(900, "nine hundred");
        map.put(1000, "one thousand");

    }

    private static String evaluate(int number) {
        if (number <= 20) {
            return map.get(number);
        } else if (number < 100) {

            int quotient = number / 10;
            int remainder = number % 10;
            if (remainder == 0) {
                return map.get(quotient * 10);
            } else {
                return format("%s-%s", map.get(quotient * 10), map.get(remainder));
            }

        } else {
            int quotient = number / 100;
            int remainder = number % 100;
            if (remainder == 0) {
                return map.get(quotient * 100);
            } else {
                return format("%s and %s", map.get(quotient * 100), evaluate(remainder));
            }

        }
    }

    private static int numberSize(int number) {
        return evaluate(number).replaceAll(" ", "").replaceAll("-", "").length();
    }

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

//        System.out.println(map);

        System.out.println(numberSize(342));
        System.out.println(numberSize(115));

        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += numberSize(i);
//            String word = evaluate(i);

//            System.out.println(word);
        }

        System.out.println("sum " + sum);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
