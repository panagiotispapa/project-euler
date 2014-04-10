package org.euler.problems;

import static org.euler.util.Tools.lcm;
import static org.euler.util.Tools.range;

public class Problem5 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        System.out.println("lcm " + lcm(range(20)));

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
