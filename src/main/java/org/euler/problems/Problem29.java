package org.euler.problems;

import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class Problem29 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        final int pSize = 8;

        int[] p2 = new int[pSize];
        int[] p3 = new int[pSize];
        int[] p5 = new int[pSize];
        int[] p6 = new int[pSize];
        int[] p7 = new int[pSize];
        int[] p10 = new int[pSize];

        p2[0] = 2;
        p3[0] = 3;
        p5[0] = 5;
        p6[0] = 6;
        p7[0] = 7;
        p10[0] = 10;

        int[] b1 = new int[101];
        int[] b2 = new int[101];

        for (int i = 1; i < pSize; i++) {
            p2[i] = p2[i - 1] * 2;
            p3[i] = p3[i - 1] * 3;
            p5[i] = p5[i - 1] * 5;
            p6[i] = p6[i - 1] * 6;
            p7[i] = p7[i - 1] * 7;
            p10[i] = p10[i - 1] * 10;

            if (p2[i] <= 100) {
                b1[p2[i]] = 2;
                b2[p2[i]] = i + 1;

            }
            if (p3[i] <= 100) {
                b1[p3[i]] = 3;
                b2[p3[i]] = i + 1;
            }
            if (p5[i] <= 100) {
                b1[p5[i]] = 5;
                b2[p5[i]] = i + 1;
            }
            if (p6[i] <= 100) {
                b1[p6[i]] = 6;
                b2[p6[i]] = i + 1;
            }
            if (p7[i] <= 100) {
                b1[p7[i]] = 7;
                b2[p7[i]] = i + 1;
            }
            if (p10[i] <= 100) {
                b1[p10[i]] = 10;
                b2[p10[i]] = i + 1;
            }

        }

        for (int i = 0; i <= 100; i++) {
            System.out.print(String.format("%4d ", i));
        }
        System.out.println();

//        System.out.println(p2);
        print(b1);
        print(b2);

        Set<Integer> powers = newHashSet();

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                if (b1[a] == 0) {
                    powers.add(a + 1000 * b);
                } else {
                    powers.add(b1[a] + 1000 * b * b2[a]);
                }
            }

        }

//        System.out.println(powers);
        System.out.println(powers.size());

//        print(p2);
//        print(p3);
//        print(p5);

//        int[] b1 = new int[98];
//        int[] b2 = new int[98];
//        for (int i = 2; i <= 100; i++) {
//            if(i==)
//        }

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static void print(int[] p) {
        for (int aP : p) {
            System.out.printf("%4d ", aP);
        }
        System.out.println();
    }

}
