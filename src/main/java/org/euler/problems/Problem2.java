package org.euler.problems;

import static org.euler.util.Tools.isEven;

public class Problem2 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        long sum = 0;

        int fibo = 1;
        int fiboPrev = 1;

        while (fibo < 4000000) {

//            System.out.println(fibo);

            if (isEven(fibo)) {
                sum += fibo;
            }
            int temp = fibo;
            fibo += fiboPrev;
            fiboPrev = temp;


        }

        System.out.println(sum);


        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }
}
