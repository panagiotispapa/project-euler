package org.euler.problems;

import org.euler.util.Tools;

public class Problem30 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int[] powers = new int[10];
        for (int i = 0; i < 10; i++) {
            powers[i] = i * i * i * i * i;
        }

        long total = 0;

        for (int i = 2; i < 20000000; i++) {

            long sum = 0;
            for (Integer number : Tools.digitsOfNumber(i)) {
                sum += powers[number];
            }

            if (sum == i) {
                System.out.println(i);
                total += i;
            }
        }

        System.out.println("total " + total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
