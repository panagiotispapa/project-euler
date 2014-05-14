package org.euler.problems;

public class Problem48 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long sum = 0;

//        System.out.println(calcPower(1, 1));
//        System.out.println(calcPower(3, 3));
//        System.out.println(calcPower(4, 4));

        for (int i = 1; i <= 1000; i++) {
            sum += calcPower(i, i);
            sum %= 1000000000000L;
        }

        System.out.println("sum " + sum);

//        primeFactors(644);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static long calcPower(long a, long b) {
        long result = 1;

        for (int i = 0; i < b; i++) {
            result *= a;
            result %= 1000000000000L;
        }

        return result;

    }

}
