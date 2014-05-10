package org.euler.problems;

import static org.euler.util.Tools.isPalindromic;
import static org.euler.util.Tools.toBinary;

public class Problem36 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long total = 0;

        for (int i = 1; i < 1000000; i++) {
            if (isPalindromic(i) && isPalindromic(toBinary(i))) {
                System.out.println(i);
                total += i;
            }

        }
        //40730
        System.out.println("total " + total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
