package org.euler.problems;

import static org.euler.util.Tools.calculatePrimes2;
import static org.euler.util.Tools.isPandigital;

public class Problem41 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int max = 0;

        boolean[] isPrime = calculatePrimes2(10000000);

        for (int i = 10; i < isPrime.length; i++) {
            if (isPrime[i] && isPandigital(i) && i > max) {
//                System.out.println(i);
                max = i;
            }
        }

        System.out.println("max " + max);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
