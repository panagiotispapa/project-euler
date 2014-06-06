package org.euler.problems;

import static org.euler.util.Tools.isPalindrome;

public class Problem4 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int limMin = 100;
        int limMax = 999;
        long max = 0;
        for (int i = limMin; i <= limMax; i++) {
            for (int j = i; j <= limMax; j++) {
                long product = i * j;
                if (isPalindrome(product, 10)) {
//                    System.out.printf("(%d,%d) %d%n", i, j, product);
                    if (product > max) {
                        max = product;
                    }
                }
            }
        }
//        max 906609
//        time required: 153

        System.out.println("max " + max);


        System.out.println("time required: " + (System.currentTimeMillis() - now));


    }
}
