package org.euler.problems;

import static org.euler.util.Tools.computeSumOfMultiples;

public class Problem1 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        System.out.println(computeSumOfMultiples(1000, 3, 5));
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
