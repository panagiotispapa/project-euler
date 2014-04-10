package org.euler.problems;

import static org.euler.util.Tools.factorsCnt;
import static org.euler.util.Tools.triangle;

public class Problem12 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        int index = 10;
        while (factorsCnt(triangle(index++)) < 500) {

        }

        System.out.println(triangle(index-1));

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
