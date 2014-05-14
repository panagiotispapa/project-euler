package org.euler.problems;

import org.euler.util.Tools;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Sets.newTreeSet;
import static org.euler.util.Tools.digitsOfNumber;

public class Problem43 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long sum = 0;

//        System.out.println(isPandigital(1406357289));
//        System.out.println(isDiv(digitsOfNumber(1406357289)));

        List<List<Integer>> perms = Tools.permutationsKofN(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 10, false);
//        System.out.println(perms.size());

//        System.out.println(perms.contains(digitsOfNumber(1406357289)));

        for (List<Integer> perm : perms) {
            if (isDiv(perm)) {
//                System.out.println(toNumber(perm));
                sum+=toNumber(perm);
            }
        }

        System.out.println("sum " + sum);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static long toNumber(List<Integer> digits) {
        long n = 0;
        long level = 1;
        for (Integer digit : digits) {
            n += digit * level;
            level *= 10;
        }

        return n;
    }

//    protected static boolean isPandigital(long number) {
//        return isPandigital(digitsOfNumber(number));
//    }

    private static boolean isDiv(List<Integer> digits) {
        int size = digits.size();
//        System.out.println(digits.get(size - 2) + " " + digits.get(size - 3) + " " + digits.get(size - 4));

//        System.out.println(build(digits, 2, 3, 4));

        return digits.get(0) != 0
                && build(digits, 2, 3, 4) % 2 == 0
                && build(digits, 3, 4, 5) % 3 == 0
                && build(digits, 4, 5, 6) % 5 == 0
                && build(digits, 5, 6, 7) % 7 == 0
                && build(digits, 6, 7, 8) % 11 == 0
                && build(digits, 7, 8, 9) % 13 == 0
                && build(digits, 8, 9, 10) % 17 == 0
                ;
    }

    private static int build(List<Integer> digits, int d1, int d2, int d3) {

        int size = digits.size();
        return digits.get(size - d1) * 100 + digits.get(size - d2) * 10 + digits.get(size - d3);

    }

    private static boolean isPandigital(List<Integer> digits) {
        return digits.size() == 10 && newTreeSet(digits).size() == 10;

    }
}
