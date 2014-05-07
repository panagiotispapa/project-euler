package org.euler.problems;

import org.euler.util.Tools;

import java.util.List;

public class Problem27 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();
        int[] squares = new int[100000];

        for (int i = 0; i < squares.length; i++) {
            squares[i] = i * i;
        }

        List<Integer> primes = Tools.calculatePrimes(100000);

//        for (int i = 1; i < 50; i++) {
//            int calc = calc(1, 41, squares, i);
//            System.out.println(i + ", " + calc + ", " + primes.contains(calc));
//        }

//        System.out.println(getN(1, 41, squares, primes));
//        System.out.println(getN(-79, 1601, squares, primes));

        int max = 0;
        int product = 0;

        for (int a = -999; a < 1000; a++) {
//            System.out.println(a);
            for (int b = -999; b < 1000; b++) {
                int n = getN(a, b, squares, primes);

                if (n == 0) {
                    System.out.println("!!!! n " + n + ", (" + a + ", " + b + ")");
                }
                if (n > max) {
                    max = n;
                    product = a * b;
//                    System.out.println("n " + n + ", (" + a + ", " + b + ")");
                }
            }

        }

        System.out.println(max + ", " + product);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static int getN(int a, int b, int[] squares, List<Integer> primes) {
//        143813

//        71, -59231
//        time required: 164761
        for (int i = 1; i < 1000; i++) {
            int calc = calc(a, b, squares, i);
            if (!primes.contains(calc)) {
                return i;
            }
//            System.out.println(i + ", " + calc + ", " + primes.contains(calc));
        }

        return 0;

    }

    private static int calc(int a, int b, int[] squares, int n) {
        return squares[n] + a * n + b;
    }

}
