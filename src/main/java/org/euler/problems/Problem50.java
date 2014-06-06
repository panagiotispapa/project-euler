package org.euler.problems;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.euler.util.Tools.calculatePrimes2;

public class Problem50 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int N = 10000000;
        boolean[] isPrime = calculatePrimes2(N);

        List<Integer> primes = newArrayList();

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int maxSteps = 0;
        int maxFound = 0;
        int limit = 1000000;

        for (int i = 3; i < primes.size(); i++) {
            if (primes.get(i) > limit) {
                break;
            } else {

                for (int k = 0; k < i; k++) {
                    int steps = 0;
                    int sum = 0;

                    for (int j = k; j + k + maxSteps < i; j++) {
                        steps++;
                        sum += primes.get(j);
                        if (sum > primes.get(i)) {
                            break;
                        } else {
                            if (primes.get(i) == sum) {
//                                System.out.println(sum + " " + steps);
                                if (steps > maxSteps) {
                                    maxSteps = steps;
                                    maxFound = sum;
                                }
                                break;
                            }
                        }
                    }

                }

            }
        }

        System.out.println("Found " + maxFound + " in " + maxSteps + " steps");

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
