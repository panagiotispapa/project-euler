package org.euler.problems;

import org.euler.util.Tools;

import static org.euler.util.Tools.digitsOfNumber;

public class Problem34 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int[] factorials = new int[10];
        for (int i = 0; i < 10; i++) {
            factorials[i] = (int) Tools.factorial(i);
        }


        long total = 0;

        for (int i = 3; i < 20000000; i++) {
            long sum = 0;

            for (Integer number : digitsOfNumber(i)) {
                sum += factorials[number];
            }


            if (sum == i) {
                System.out.println(i);
                total+=i;
            }
        }
        //40730
        System.out.println("total "+ total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
