package org.euler.problems;

import static org.euler.util.Tools.sortInt;

public class Problem52 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        for (int i = 1; i < 100000000; i++) {
            int s1 = sortInt(i);
            int s2 = sortInt(2 * i);
            int s3 = sortInt(3 * i);
            int s4 = sortInt(4 * i);
            int s5 = sortInt(5 * i);
            int s6 = sortInt(6 * i);

            if (s1 == s2 && s2 == s3 && s3 == s4 && s4 == s5 && s5 == s6) {
                System.out.println(i);
                break;
            }
        }

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
