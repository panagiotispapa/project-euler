package org.euler.problems;

import com.google.common.collect.Lists;
import org.euler.util.Tools;

import java.util.List;

import static java.lang.System.currentTimeMillis;

public class Problem35 {

    public static void main(String[] args) {
        long now = currentTimeMillis();

        int power = 1;
        int[] powers = new int[7];
        for (int i = 0; i < powers.length; i++) {
            powers[i] = power;
            power *= 10;
        }

        boolean[] isPrime = Tools.calculatePrimes2(1000010);
//        System.out.println(buildAllRotations(197, powers));

        int total = 0;
        for (int i = 1; i < 1000010; i++) {

            if (isPrime[i] && allRotationsArePrimes(i, powers, isPrime)) {
//                System.out.println(prime);
                total++;
            }

        }

        System.out.println("total " + total);

//        System.out.println(allRotationsArePrimes(197, powers, primes));

//        System.out.println(rotateNext(chars));

        System.out.println("time required: " + (currentTimeMillis() - now));

    }

    private static boolean allRotationsArePrimes(int number, int[] powers, boolean[] primes) {

        List<Integer> rotations = buildAllRotations(number, powers);

        for (Integer rotation : rotations) {
            if (!primes[rotation]) {

                return false;
            }
        }
        return true;
    }

    private static List<Integer> buildAllRotations(int number, int[] powers) {

        List<Integer> rotations = Lists.newArrayList();

        char[] chars = String.valueOf(number).toCharArray();

        char[] rot = chars;
        for (int i = 0; i < chars.length - 1; i++) {
            rot = rotateNext(rot);
            rotations.add(toInt(rot, powers));
//            System.out.println(rot);
        }

        return rotations;
    }

    private static int toInt(char[] chars, int[] powers) {
        int toR = 0;

        for (int i = 0; i < chars.length; i++) {
            toR += powers[i] * Character.getNumericValue(chars[chars.length - 1 - i]);
        }

        return toR;

    }

    private static char[] rotateNext(char[] chars) {
        char[] toR = new char[chars.length];

        for (int i = 1; i < chars.length; i++) {
            toR[i - 1] = chars[i];
        }

        toR[chars.length - 1] = chars[0];

        return toR;
    }

}
