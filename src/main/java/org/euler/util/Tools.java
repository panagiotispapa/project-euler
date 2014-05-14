package org.euler.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Character.getNumericValue;
import static java.lang.Integer.parseInt;

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

    public static boolean isEven(int a) {
        return a % 2 == 0;
    }

    public static boolean isEven(long a) {
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

        List<Integer> primes = newArrayList();

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

    public static boolean[] calculatePrimes2(int N) {

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

        return isPrime;

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
        List<Long> factors = newArrayList();
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

    public static Set<Long> properDivisors(long number) {
        Set<Long> properDivisors = Sets.newTreeSet();
        List<Long> primeFactors = primeFactors(number);

        properDivisors.addAll(primeFactors);

        for (int i = 2; i < primeFactors.size(); i++) {
            List<List<Long>> combinations = combinationsKofN(primeFactors, i, false);
            for (List<Long> combination : combinations) {
                properDivisors.add(product(combination));
            }
        }

        properDivisors.add(1L);
        properDivisors.remove(number);
        return properDivisors;
    }

    private static long product(Iterable<Long> numbers) {
        long product = 1;
        for (Long number : numbers) {
            product *= number;
        }
        return product;

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

    public static long sum(Iterable<Long> numbers) {
        long sum = 0L;
        for (Long number : numbers) {
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

        List<Integer> powers = newArrayList();

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

    public static void addNumberTo(int[] bigSum, String number) {
        int length = number.length();
        for (int i = 0; i < length; i++) {
            addNumberTo(bigSum, Character.getNumericValue(number.charAt(length - i - 1)), i);
        }
    }

    public static void addNumberTo(int[] bigSum, int[] bigNumber) {

        int length = bigNumber.length;
        for (int i = 0; i < length; i++) {
            addNumberTo(bigSum, bigNumber[i], i);
        }
    }

    public static void addNumberTo(int[] bigSum, int toAdd, int start) {

        int numberToAdd = toAdd;

        for (int i = start; i < bigSum.length; i++) {
            if (numberToAdd == 0) {
                break;
            } else {
                int sum = bigSum[i] + numberToAdd;
                numberToAdd = sum / 10;
                bigSum[i] = sum % 10;
            }
        }

    }

    public static void multiplyBy(int[] bigNumber, int multiplier) {

        int numberToAdd = 0;

        for (int i = 0; i < bigNumber.length; i++) {

            int product = bigNumber[i] * multiplier + numberToAdd;

            numberToAdd = product / 10;
            bigNumber[i] = product % 10;
        }
    }

    public static int[] factorialBig(int number) {

        int[] bigNumber = new int[10000];

        bigNumber[0] = 1;

        for (int i = 1; i <= number; i++) {
            multiplyBy(bigNumber, i);
        }

        return bigNumber;
    }

    public static int[] power(int base, int power) {

        int[] bigNumber = new int[10000];

        bigNumber[0] = base;

        for (int i = 0; i < power - 1; i++) {
            multiplyBy(bigNumber, base);
        }

        return bigNumber;
    }

    public static void printArrayRev(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%d", ar[ar.length - i - 1]);
        }
        System.out.println("");

    }

    public static void printArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%d", ar[i]);
        }
        System.out.println("");

    }

    public static long addDigits(int[] bigNumber) {
        long sum = 0;
        for (int digit : bigNumber) {
            sum += digit;
        }
        return sum;
    }

    public static String strValue(int[] bigNumber) {
        StringBuilder builder = new StringBuilder();

        for (int i = bigNumber.length - 1; i >= 0; i--) {
            builder.append(bigNumber[i]);
        }

        return builder.toString();
    }

    public static String strValueTrimZeros(int[] bigNumber) {
        String fullValue = strValue(bigNumber);

        return fullValue.replaceAll("^0*", "");
    }

    public static long nextCollatz(long number) {

        if (isEven(number)) {
            return number / 2;
        } else {
            return 3 * number + 1;
        }

    }

    public static long lengthOfCollatz(long number) {

        long size = 1;
        long current = nextCollatz(number);
        while (current > 1) {
            current = nextCollatz(current);
            size++;
        }
        return size + 1;
    }

    public static <T> List<List<T>> combinationsKofN(List<T> items, int k, boolean withDuplicates) {
        int[] selections = new int[k];
        List<List<T>> results = Lists.newArrayList();
        if (withDuplicates) {
            combinationsKofNWithDuplicates(items, results, selections, 0);
        } else {
            combinationsKofNWithoutDuplicates(items, results, selections, 0);
        }
        return results;

    }

    private static <T> void combinationsKofNWithDuplicates(List<T> items, List<List<T>> results, int[] selections, int index) {
        if (index == selections.length) {
            copyToResults(items, selections, results);
        } else {
            final int start = index > 0 ? selections[index - 1] : 0;
            for (int i = start; i < items.size(); i++) {
                selections[index] = i;
                combinationsKofNWithDuplicates(items, results, selections, index + 1);
            }
        }

    }

    private static <T> void combinationsKofNWithoutDuplicates(List<T> items, List<List<T>> results, int[] selections, int index) {
        if (index == selections.length) {
            copyToResults(items, selections, results);
        } else {
            final int start = index > 0 ? selections[index - 1] + 1 : 0;
            for (int i = start; i < items.size(); i++) {
                selections[index] = i;
                combinationsKofNWithoutDuplicates(items, results, selections, index + 1);
            }
        }

    }

    public static <T> List<List<T>> permutationsKofN(List<T> items, int k, boolean withDuplicates) {
        int[] selections = new int[k];
        List<List<T>> results = Lists.newArrayList();
        if (withDuplicates) {
            permutationsKofNWithDuplicates(items, results, selections, 0);
        } else {
            permutationsKofNWithoutDuplicates(items, results, selections, 0);
        }
        return results;

    }

    private static <T> void permutationsKofNWithDuplicates(List<T> items, List<List<T>> results, int[] selections, int index) {
        if (index == selections.length) {
            copyToResults(items, selections, results);
        } else {
//            final int start = index > 0 ? selections[index - 1] : 0;
            for (int i = 0; i < items.size(); i++) {
                selections[index] = i;
                permutationsKofNWithDuplicates(items, results, selections, index + 1);
            }
        }

    }

    private static <T> void permutationsKofNWithoutDuplicates(List<T> items, List<List<T>> results, int[] selections, int index) {
        if (index == selections.length) {
            copyToResults(items, selections, results);
        } else {
            for (int i = 0; i < items.size(); i++) {

                final boolean used = findIfUsed(index, selections, i);
                if (!used) {
                    selections[index] = i;
                    permutationsKofNWithoutDuplicates(items, results, selections, index + 1);
                }
            }
        }

    }

    private static boolean findIfUsed(int index, int[] selections, int current) {
        for (int i = 0; i < index; i++) {
            if (selections[i] == current) {
                return true;
            }
        }

        return false;
    }

    private static <T> void copyToResults(List<T> items, int[] selections, List<List<T>> results) {
        List<T> result = Lists.newArrayList();
        for (int selection : selections) {
            result.add(items.get(selection));
        }
        results.add(result);

    }

    private static void print(char[] chars) {
        for (char ch : chars) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static long sumOfProperDivisors(long number) {
        return sum(properDivisors(number));
    }

    public static boolean isPerfect(long number) {
        return sumOfProperDivisors(number) == number;
    }

    public static boolean isDeficient(long number) {
        return sumOfProperDivisors(number) < number;
    }

    public static boolean isAbundant(long number) {
        return sumOfProperDivisors(number) > number;
    }

    public static List<Integer> toBinary(int a) {
        List<Integer> b = Lists.newArrayList();

        while (a != 0) {
            b.add(a % 2);
            a /= 2;
        }

        return b;
    }

    public static List<Integer> digitsOfNumber(int number) {
        List<Integer> digits = Lists.newArrayList();

        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }

        return digits;
    }
    public static List<Integer> digitsOfNumber(long number) {
        List<Integer> digits = Lists.newArrayList();

        while (number > 0) {
            digits.add((int) (number % 10));
            number /= 10;
        }

        return digits;
    }

    public static boolean isPandigital(int number) {
        return isPandigital(digitsOfNumber(number));
    }

    public static boolean isPandigital(List<Integer> digits) {
        Collections.sort(digits);
        int size = digits.size();

        if (size > 9) {
            return false;
        }

        for (int i = 0; i < size; i++) {
//            System.out.println(digits.get(i) + " " + index);

            if (digits.get(i) != (i+1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPandigital(int number, int n) {
        List<Integer> digits = digitsOfNumber(number);
        return digits.size() == n && isPandigital(digits);

    }

    public static boolean isPandigital(String number, int n) {
        return isPandigital(parseInt(number), n);
    }
//    public static boolean isPandigital(String number, int n) {
//        return isPandigital(parseInt(number), n);
//    }

    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(int number) {

        return isPalindromic(digitsOfNumber(number));

    }

    public static boolean isPalindromic(List<Integer> digits) {

        for (int i = 0; i < digits.size() / 2; i++) {
            if (!digits.get(i).equals(digits.get(digits.size() - 1 - i))) {
                return false;
            }
        }

        return true;

    }

    public static boolean isTruncatableLR(int number, boolean[] isPrime) {

        String str = String.valueOf(number);

        int length = str.length();
        for (int i = 1; i < length; i++) {
            String substring = str.substring(i, length);
//            System.out.println(substring);
            if (!isPrime[Integer.valueOf(substring)]) {
                return false;
            }
        }

        return true;

    }

    public static boolean isTruncatableRL(int number, boolean[] isPrime) {

        String str = String.valueOf(number);

        int length = str.length();
        for (int i = 1; i < length; i++) {
            String substring = str.substring(0, length - i);
//            System.out.println(substring);
            if (!isPrime[Integer.valueOf(substring)]) {
                return false;
            }
        }

        return true;

    }

}

