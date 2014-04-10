package org.euler.problems;

import static org.euler.util.Tools.primeFactors;

public class Problem3 {

    public static void main(String[] args) {


        long now = System.currentTimeMillis();
        long max = 600851475143l;
//        long max = 13195l;


        System.out.println(primeFactors(max));

//        System.out.println(Tools.calculatePrimes(600851475143));


        System.out.println("time required: " + (System.currentTimeMillis() - now));


    }
}
