package org.euler.problems;

import java.util.List;

import static org.euler.util.Tools.calculatePrimes;

public class Problem10 {

    public static void main(String[] args) {

        List<Integer> primes = calculatePrimes(2000000);

        long sum = 0;
        for (Integer prime : primes) {
            sum+=prime;
        }

        System.out.println(sum);
//        System.out.println(primes);

    }
}
