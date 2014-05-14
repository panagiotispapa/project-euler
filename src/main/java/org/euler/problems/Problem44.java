package org.euler.problems;

import com.google.common.collect.Sets;

import java.util.Set;

public class Problem44 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long[] pents = new long[10500];
        Set<Long> pentsSet = Sets.newHashSet();


        for (int i = 0; i < pents.length; i++) {
            pents[i] = pent(i + 1);
            pentsSet.add(pents[i]);
        }

//        for (int i = 0; i < pents.length; i++) {
//            System.out.println(pents[i]);
//        }

        for (int i = 0; i < pents.length - 1; i++) {
            for (int j = i + 1; j < pents.length; j++) {
                if(pentsSet.contains(pents[i]+pents[j]) && pentsSet.contains(pents[j]-pents[i])) {
                    System.out.println("!!!!!!! " +pents[i] + " " + pents[j] + " " + (pents[j]-pents[i]));
                }
            }
        }

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static long pent(long n) {
        return n * (3 * n - 1) / 2;
    }

}
