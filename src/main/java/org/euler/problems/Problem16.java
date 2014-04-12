package org.euler.problems;

import static org.euler.util.Tools.addDigits;
import static org.euler.util.Tools.power;

public class Problem16 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        System.out.println(addDigits(power(2, 1000)));

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
