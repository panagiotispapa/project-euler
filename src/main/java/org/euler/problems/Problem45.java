package org.euler.problems;

import com.google.common.collect.Sets;

import java.util.Set;

public class Problem45 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        Set<Long> pentsSet = Sets.newHashSet();
        Set<Long> triangSet = Sets.newHashSet();
        Set<Long> hexSet = Sets.newHashSet();


        for (long i = 0; i < 180000; i++) {

            triangSet.add(trian(i + 1));
            pentsSet.add(pent(i + 1));
            hexSet.add(hex(i + 1));

        }


//        System.out.println(hexSet);

        for (Long triang : triangSet) {
            if(hexSet.contains(triang) && pentsSet.contains(triang)){
                System.out.println("found " + triang);
            }
        }


        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static long pent(long n) {
        return n * (3 * n - 1) / 2;
    }

    private static long trian(long n) {
        return n * (n + 1) / 2;
    }

    private static long hex(long n) {
        return n * (2 * n - 1);
    }

}
