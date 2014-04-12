package org.euler.problems;

import static org.euler.util.Tools.lengthOfCollatz;

public class Problem14 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        long max = 0;
        int startingNumber = 2;

        for (int i = 2; i < 1000000; i++) {
            long size = lengthOfCollatz(i);
            if (size > max) {
                max = size;
                startingNumber = i;
            }
        }

        System.out.printf("starting number %d max %d %n",startingNumber, max);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
