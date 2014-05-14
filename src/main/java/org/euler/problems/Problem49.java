package org.euler.problems;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.TreeSet;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newTreeSet;
import static org.euler.util.Tools.calculatePrimes;
import static org.euler.util.Tools.digitsOfNumber;

public class Problem49 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        List<Integer> primes = newArrayList(filter(calculatePrimes(100000), new Predicate<Integer>() {
            @Override
            public boolean apply(Integer prime) {
                return prime > 1000 && prime < 10000;
            }
        }));

//        System.out.println(primes.size());

//        System.out.println(newTreeSet(digitsOfNumber(1487)).equals(newTreeSet(digitsOfNumber(4817))));
//        System.out.println(newTreeSet(digitsOfNumber(1487)).equals(newTreeSet(digitsOfNumber(4816))));

        TreeSet<Integer> foundPrimes = Sets.newTreeSet();

        for (Integer prime : primes) {

//            TreeSet<Integer> digits = newTreeSet(digitsOfNumber(prime));
            int found = 0;

            for (Integer otherPrime : primes) {
                if (!otherPrime.equals(prime) && newTreeSet(digitsOfNumber(prime)).equals(newTreeSet(digitsOfNumber(otherPrime)))) {
                    if (Math.abs(prime - otherPrime) == 3330 || Math.abs(prime - otherPrime) == 2 * 3330){
//                        System.out.println(prime);
                        found++;
                    }
                }
            }

            if (found == 2) {
                foundPrimes.add(prime);
//                System.out.println(prime);
            }

        }

        System.out.println(foundPrimes);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
