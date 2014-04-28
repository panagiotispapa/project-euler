package org.euler.problems;

import static org.euler.util.Tools.properDivisors;
import static org.euler.util.Tools.sum;

public class Problem21 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        boolean isAmicable[] = new boolean[10000];

        long sum = 0;

        for (int i = 2; i < isAmicable.length; i++) {
            if (!isAmicable[i]) {
                long d = d(i);
                if (d != i && i == d(d)) {
                    isAmicable[i] = true;
                    isAmicable[(int) d] = true;
                    sum+=i;
                    sum+=d;
                    System.out.println("( " + i + ", " + d + ")");
                }
            }

        }

        System.out.println(sum);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static long d(long number) {
        return sum(properDivisors(number));
    }

}
