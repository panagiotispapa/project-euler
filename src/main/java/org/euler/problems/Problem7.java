package org.euler.problems;

import java.util.List;

import static org.euler.util.Tools.calculatePrimes;

public class Problem7 {

    public static void main(String[] args) {
        List<Integer> primes = calculatePrimes(400000);

        System.out.println(primes.get(6-1));
        System.out.println(primes.get(10001-1));
        System.out.println(primes.size());


    }
}
