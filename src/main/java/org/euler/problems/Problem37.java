package org.euler.problems;

import static org.euler.util.Tools.*;

public class Problem37 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long total = 0;

        boolean[] isPrime = calculatePrimes2(10000000);

        for (int i = 10; i < isPrime.length; i++) {
            if (isPrime[i] && isTruncatableLR(i, isPrime) && isTruncatableRL(i, isPrime)) {
                System.out.println(i);
                total += i;
            }
        }

        //40730
        System.out.println("total " + total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
