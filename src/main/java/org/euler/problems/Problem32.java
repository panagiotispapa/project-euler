package org.euler.problems;

import com.google.common.collect.Sets;
import org.euler.util.Tools;

import java.util.Set;

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

                        if (isPandigital(concatLongs(factor, i / factor, i))) {
//                            System.out.println(i + " " + allNumbers);
                            found.add(i);
                        }

                    }

                }

            }
        }

        System.out.println(found);

        for (Integer number : found) {
            total += number;
        }

//        [5796, 5346, 7632, 7852, 7254, 6952, 4396]
//        total 45228
//        time required: 2972
//

        System.out.println("total " + total);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static boolean isPandigital(long n) {

        return sortLong(n) == 987654321;

    }

}
