package org.euler.problems;

import static com.google.common.collect.Sets.newHashSet;
import static org.euler.util.Tools.primeFactors;

public class Problem47 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int found = 0;
        for (int i = 10; i < 1000000; i++) {
            if (newHashSet(primeFactors(i)).size() == 4) {
                found++;
            } else {
                found = 0;
            }
            if (found == 4) {
                System.out.println(i);
                break;
            }
        }

//        primeFactors(644);

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
