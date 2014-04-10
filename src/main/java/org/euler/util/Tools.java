package org.euler.util;

import com.google.common.collect.Lists;

import java.util.List;

import static java.lang.Character.getNumericValue;

public class Tools {

    public static boolean isFactorOfAny(int a, int... possibleFactors) {

        for (int possibleFactor : possibleFactors) {
            if (isFactorOf(a, possibleFactor)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isFactorOfAll(int a, int... possibleFactors) {

        for (int possibleFactor : possibleFactors) {
            if (!isFactorOf(a, possibleFactor)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isFactorOfAll(long a, List<Integer> possibleFactors) {

        for (Integer possibleFactor : possibleFactors) {
            if (!isFactorOf(a, possibleFactor)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isEven(Integer a) {
        return a % 2 == 0;
    }

    public static boolean isOdd(Integer a) {
        return a % 2 == 1;
    }

    public static boolean isFactorOf(Integer a, Integer b) {
        return a % b == 0;
    }

    public static boolean isFactorOf(int a, int b) {
        return a % b == 0;
    }

    public static boolean isFactorOf(long a, Integer b) {
        return a % b == 0;
    }

    public static boolean isMultipleOf(Long a, Long b) {
        return a % b == 0;
    }

    public static long computeSumOfMultiples(int max, int... factors) {

        long sum = 0;

        for (int i = 1; i < max; i++) {
            if (isFactorOfAny(i, factors)) {
                sum += i;
            }
        }

        return sum;

    }

    public static List<Integer> calculatePrimes(int N) {

        List<Integer> primes = Lists.newArrayList();

        int primesCnt = 0;

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
            primesCnt++;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i * i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                    primesCnt--;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);

            }
        }
        return primes;
    }

    public static boolean isPrime(long n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        //if not, then just check the odds
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static List<Long> primeFactors(long numbers) {
        long n = numbers;
        List<Long> factors = Lists.newArrayList();
        for (long i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static long product(char[] numbers) {
        long product = 1l;

        for (char number : numbers) {
            product *= getNumericValue(number);
        }
        return product;
    }

    public static int[] findPythTripletsWithSum(int sum) {
        final long[] squares = new long[sum];

        for (int i = 0; i < sum; i++) {
            squares[i] = i * i;
        }

        for (int a = 1; a < sum; a++) {
            for (int b = a + 1; b < sum - a; b++) {
                int c = sum - a - b;

                if (squares[c] == squares[a] + squares[b]) {
                    System.out.printf("%d, %d, %d %d %n", a, b, c, a * b * c);
                    return new int[]{a, b, c};
                }
            }

        }

        return new int[]{};
    }

    public static long max(long... numbers) {
        long max = 0;
        for (long number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;

    }

    public static int max(int... numbers) {
        int max = 0;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;

    }

    public static long product(int... numbers) {
        long product = 1L;
        for (int number : numbers) {
            product *= number;
        }
        return product;

    }

    public static long sum(int... numbers) {
        long sum = 0L;
        for (int number : numbers) {
            sum += number;
        }
        return sum;

    }

    public static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    public static long gcd(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    public static long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    public static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    public static long[] range(int max) {
        long[] r = new long[max];

        for (int i = 0; i < max; i++) {
            r[i] = i + 1;
        }
        return r;
    }

    public static long permutationsCnt(int n, int r) {
        long cnt = 1;

        for (int i = 0; i < r; i++) {
            cnt *= n;
        }
        return cnt;
    }

    public static long permutationsWithoutRepetitionCnt(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    public static long combinationsWithoutRepetitionCnt(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static long combinationsWithRepetitionCnt(int n, int r) {
        return factorial(n + r - 1) / (factorial(r) * factorial(n - 1));
    }

    public static long factorial(int n) {
        long factorial = 1;
        for (int i = 0; i < n; i++) {
            factorial *= (i + 1);
        }

        return factorial;

    }

    public static long triangle(int n) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (i + 1);
        }
        return cnt;
    }

    public static int factorsCnt(long n) {

        //http://www.wikihow.com/Find-How-Many-Factors-Are-in-a-Number

//        List<Long> primeFactors = primeFactors(n);
        List<Long> primeFactors = primeFactors(n);


        List<Integer> powers = Lists.newArrayList();


        long current = primeFactors.get(0);

        int cnt = 0;
        for (Long primeFactor : primeFactors) {
            if (current == primeFactor) {
                cnt++;
            } else {
                powers.add(cnt);
                cnt = 1;
                current = primeFactor;
            }
        }

        powers.add(cnt);

        int factorsCnt = 1;
        for (Integer power : powers) {
            factorsCnt *= (power + 1);
        }

//        System.out.println(primeFactors(n));
//        System.out.println(factorsCnt);

        return factorsCnt;

    }
}

