package org.euler.problems;

import static org.euler.util.Tools.isPalindrome;
import static org.euler.util.Tools.toBinary;
import static org.euler.util.Tools.toBinaryStr;

public class Problem36 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long total = 0;

        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(i) && isPalindrome(toBinaryStr(i))) {
                System.out.println(i);
                total += i;
            }

        }
        //40730
//        total 872187
//        time required: 90

        System.out.println("total " + total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
