package org.euler.problems;

import org.euler.util.Tools;

import java.util.List;

public class Problem46 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int[] squares = new int[100];

        for (int i = 0; i < squares.length; i++) {
            squares[i] = 2 * i * i;
        }

        List<Integer> primes = Tools.calculatePrimes(1000000);
        boolean[] isPrime = Tools.calculatePrimes2(1000000);

        for (int i = 3; i < 10000; i += 2) {
            if (!isPrime[i]) {
//                System.out.println(i);

                if (!find(i, primes, squares)) {
                    System.out.println("!!!!! " + i);
                }

            }
        }

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static boolean find(int i, List<Integer> primes, int[] squares) {
        for (Integer prime : primes) {
            for (int square : squares) {
                if (i == prime + square) {
//                    System.out.println(prime + " + " + square + " = " + i);
                    return true;
                }
            }

        }

        return false;
    }

}
