package org.euler.problems;

import static org.euler.util.Tools.findPythTripletsWithSum;

public class Problem9 {

    public static void main(String[] args) {


        long now = System.currentTimeMillis();

        int[] triplets = findPythTripletsWithSum(1000);

        System.out.println(triplets[0]*triplets[1]*triplets[2]);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }
}
