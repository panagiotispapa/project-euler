package org.euler.problems;

import com.google.common.collect.Sets;
import org.euler.util.Tools;

import java.util.Set;

import static java.lang.String.format;
import static org.euler.util.Tools.*;

public class Problem32 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        long total = 0;

        boolean[] isPrime = Tools.calculatePrimes2(100000);

        Set<Integer> found = Sets.newHashSet();
        for (int i = 1; i < 100000; i++) {
            if (!isPrime[i]) {
                Set<Long> factors = properDivisors(i);

                if (factors.size() > 2) {
                    for (Long factor : factors) {
                        String allNumbers = format("%d%d%d", factor, i / factor, i);
//                        System.out.println(allNumbers);
                        if (allNumbers.length() < 10 && isPandigital(allNumbers, 9)) {
//                            System.out.println(i + " " + allNumbers);
                            found.add(i);
                        }

                    }

                }

            }
        }

        System.out.println(found);

        for (Integer number : found) {
            total+=number;
        }

        System.out.println("total " + total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
