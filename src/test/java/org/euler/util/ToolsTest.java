package org.euler.util;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.euler.util.Tools.*;
import static org.fest.assertions.api.Assertions.assertThat;

public class ToolsTest {

    @Test
    public void testIsMultipleOf() throws Exception {
//        assertThat(isFactorOf(9, 3)).isTrue();
//        assertThat(isFactorOf(9, 4)).isFalse();
    }

    @Test
    public void testIsFactorOfMany() throws Exception {

        assertThat(isFactorOfAny(9, 4, 5)).isFalse();
        assertThat(isFactorOfAny(9, 3, 5)).isTrue();

    }

    @Test
    public void testComputeSumOfMultiples() throws Exception {
        assertThat(computeSumOfMultiples(10, 3, 5)).isEqualTo(23);
    }

    @Test
    public void testIsEven() throws Exception {
        assertThat(isEven(3)).isFalse();
        assertThat(isEven(4)).isTrue();
    }

    @Test
    public void testCalculatePrimes() throws Exception {

        assertThat(calculatePrimes(10)).containsOnly(2, 3, 5, 7);
        assertThat(calculatePrimes(15)).containsOnly(2, 3, 5, 7, 11, 13);

    }

    @Test
    public void testIsPalindrome() throws Exception {
        assertThat(isPalindrome(String.valueOf(121))).isTrue();
        assertThat(isPalindrome(String.valueOf(1221))).isTrue();
        assertThat(isPalindrome(String.valueOf(9009))).isTrue();
        assertThat(isPalindrome(String.valueOf(9019))).isFalse();
        assertThat(isPalindrome(String.valueOf(122))).isFalse();

    }

    @Test
    public void testIsFactorOfAll() throws Exception {
        assertThat(isFactorOfAll(20, asList(4, 5))).isTrue();
        assertThat(isFactorOfAll(2520, asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))).isTrue();

    }

    @Test
    public void testComputeProduct() throws Exception {
        assertThat(product(new char[]{'2', '3'})).isEqualTo(6);
        assertThat(product(new char[]{'2', '3', '4'})).isEqualTo(24);
    }

    @Test
    public void testFindPythTripletsWithSum() throws Exception {
        assertThat(findPythTripletsWithSum(1000)).isEqualTo(new int[]{200, 375, 425});

    }

    @Test
    public void testCalculateProduct() throws Exception {
        assertThat(product(2, 4)).isEqualTo(8);
        assertThat(product(7, 4, 2)).isEqualTo(56);
    }

    @Test
    public void testCalculateSum() throws Exception {
        assertThat(sum(2, 4)).isEqualTo(6);
        assertThat(sum(7, 2, 4)).isEqualTo(13);
    }

    @Test
    public void testRange() throws Exception {
        assertThat(range(3)).isEqualTo(new long[]{1, 2, 3});
        assertThat(range(7)).isEqualTo(new long[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    public void testFactorial() throws Exception {
        assertThat(factorial(4)).isEqualTo(24);
        assertThat(factorial(7)).isEqualTo(5040);
        assertThat(factorial(1)).isEqualTo(1);
    }

    @Test
    public void testPermutationsCnt() throws Exception {
        assertThat(permutationsCnt(10, 3)).isEqualTo(1000);
    }

    @Test
    public void testPermutationsWithoutRepetitionCnt() throws Exception {
        assertThat(permutationsWithoutRepetitionCnt(16, 3)).isEqualTo(3360);
    }

    @Test
    public void testCombinationsWithoutRepetitionCnt() throws Exception {
        assertThat(combinationsWithoutRepetitionCnt(16, 3)).isEqualTo(560);
        assertThat(combinationsWithoutRepetitionCnt(4, 4)).isEqualTo(1);
        assertThat(combinationsWithoutRepetitionCnt(3, 2)).isEqualTo(3);
        assertThat(combinationsWithoutRepetitionCnt(3, 3)).isEqualTo(1);
        assertThat(combinationsWithoutRepetitionCnt(2, 2)).isEqualTo(1);
    }

    @Test
    public void testCombinationsWithRepetitionCnt() throws Exception {
        assertThat(combinationsWithRepetitionCnt(5, 3)).isEqualTo(35);

    }

    @Test
    public void testTriangle() throws Exception {
        assertThat(triangle(1)).isEqualTo(1);
        assertThat(triangle(7)).isEqualTo(28);

    }

    @Test
    public void testFactorsCnt() throws Exception {
        assertThat(factorsCnt(3)).isEqualTo(2);
        assertThat(factorsCnt(6)).isEqualTo(4);
        assertThat(factorsCnt(10)).isEqualTo(4);
        assertThat(factorsCnt(15)).isEqualTo(4);
        assertThat(factorsCnt(21)).isEqualTo(4);
        assertThat(factorsCnt(28)).isEqualTo(6);

    }

    @Test
    public void testPrimeFactors() throws Exception {
        assertThat(primeFactors(13195)).containsOnly(5L, 7L, 13L, 29L);

    }

    @Test
    public void testProperDivisors() throws Exception {
        assertThat(properDivisors(220)).containsOnly(1L, 2L, 4L, 5L, 10L, 11L, 20L, 22L, 44L, 55L, 110L);
        assertThat(properDivisors(284)).containsOnly(1L, 2L, 4L, 71L, 142L);

//        System.out.println(properDivisors(3));
//        System.out.println(properDivisors(284));
//        System.out.println(properDivisors(220));
    }

    @Test
    public void testAddNumberToBigSum() throws Exception {
        int[] bigSum = new int[100];

        addNumberTo(bigSum, 4, 0);
        addNumberTo(bigSum, 6, 0);
        addNumberTo(bigSum, 3, 0);
        addNumberTo(bigSum, 9, 0);
        addNumberTo(bigSum, 19, 0);
//        System.out.println(strValue(bigSum));
        assertThat(strValue(bigSum)).endsWith("00041");

        addNumberTo(bigSum, "12342");
//        System.out.println(strValue(bigSum));
        assertThat(strValue(bigSum)).endsWith("0012383");

    }

    @Test
    public void testMultiplyBy() throws Exception {
        int[] bigNumber = new int[100];

        bigNumber[1] = 4;
        bigNumber[0] = 3;

        multiplyBy(bigNumber, 2);

        assertThat(strValue(bigNumber)).endsWith("00086");
        multiplyBy(bigNumber, 3);
        assertThat(strValue(bigNumber)).endsWith("000258");

        multiplyBy(bigNumber, 12);
        assertThat(strValue(bigNumber)).endsWith("0003096");
        System.out.println(strValue(bigNumber));
    }

    @Test
    public void testFactorialBig() throws Exception {
//        System.out.println(strValue(factorialBig(10)));
        assertThat(strValue(factorialBig(10))).endsWith("0003628800");
        assertThat(addDigits(factorialBig(10))).isEqualTo(27);
    }

    @Test
    public void testAddDigits() throws Exception {

        int[] bigNumber = new int[100];

        bigNumber[2] = 9;
        bigNumber[1] = 4;
        bigNumber[0] = 3;

        assertThat(addDigits(bigNumber)).isEqualTo(9 + 4 + 3);
    }

    @Test
    public void testPower() throws Exception {
        assertThat(strValue(power(2, 3))).endsWith("0008");
        assertThat(strValue(power(2, 5))).endsWith("0032");
        assertThat(strValue(power(2, 15))).endsWith("0032768");
        assertThat(addDigits(power(2, 15))).isEqualTo(26);
    }

    @Test
    public void testDeleteZerosFromBigNumberStrValue() throws Exception {
        int[] bigSum = new int[100];

        addNumberTo(bigSum, 4, 0);
        addNumberTo(bigSum, 6, 0);
        addNumberTo(bigSum, 3, 0);
        addNumberTo(bigSum, 9, 0);
        addNumberTo(bigSum, 19, 0);

        assertThat(strValue(bigSum)).endsWith("00041");
        assertThat(strValueTrimZeros(bigSum)).isEqualTo("41");

    }

    @Test
    public void testNextCollatz() throws Exception {
        assertThat(nextCollatz(13)).isEqualTo(40);
        assertThat(nextCollatz(40)).isEqualTo(20);
    }

    @Test
    public void testLengthOfCollatz() throws Exception {
        assertThat(lengthOfCollatz(13)).isEqualTo(10);

    }

    @Test
    public void testCombinationsKofN() throws Exception {
        List<Integer> items = Arrays.asList(0, 1, 2, 3);

        List<List<Integer>> comb2of4WithDuplicates = combinationsKofN(items, 2, true);
//        System.out.println(comb2of4WithDuplicates);
        assertThat(comb2of4WithDuplicates.size()).isEqualTo((int) combinationsWithRepetitionCnt(4, 2));

        List<List<Integer>> comb2of4WithoutDuplicates = combinationsKofN(items, 2, false);
//        System.out.println(comb2of4WithoutDuplicates);
        assertThat(comb2of4WithoutDuplicates.size()).isEqualTo((int) combinationsWithoutRepetitionCnt(4, 2));

        List<List<Integer>> perm2of4WithDuplicates = permutationsKofN(items, 2, true);
//        System.out.println(perm2of4WithDuplicates);
        assertThat(perm2of4WithDuplicates.size()).isEqualTo((int) permutationsCnt(4, 2));

        List<List<Integer>> perm2of4WithoutDuplicates = permutationsKofN(items, 2, false);
//        System.out.println(perm2of4WithoutDuplicates);
        assertThat(perm2of4WithoutDuplicates.size()).isEqualTo((int) permutationsWithoutRepetitionCnt(4, 2));

    }

    @Test
    public void testPerfectNumbers() throws Exception {
        assertThat(isPerfect(28L)).isTrue();
        assertThat(isAbundant(12L)).isTrue();

    }

    @Test
    public void testToBinary() throws Exception {

        assertThat(toBinary(3)).isEqualTo(11);
        assertThat(toBinary(5)).isEqualTo(101);
        assertThat(toBinary(6)).isEqualTo(110);
        assertThat(toBinary(4)).isEqualTo(100);
        assertThat(toBinaryStr(4)).isEqualTo("100");
        assertThat(toBinaryStr(1000000)).isEqualTo("11110100001001000000");

    }

    @Test
    public void testPowers() throws Exception {

        BigInteger[] powers = new BigInteger[9];
        BigInteger current = new BigInteger("2");
//        BigInteger b = new BigInteger("4294967296");
//        b.multiply(new BigInteger("4294967296"));
//        System.out.println(b.multiply(new BigInteger("4294967296")).toString());
//        System.out.println(String.valueOf(4294967296L*4294967296L));
        for (int i = 0; i < powers.length; i++) {
            powers[i] = current;
            current = current.multiply(current);
//            System.out.printf("%d %s%n", i, String.valueOf(current) );
//            System.out.println(current.toString());

        }

        for (BigInteger power : powers) {
            System.out.println(power.toString());
        }

    }

    @Test
    public void testDigitsOfNumber() throws Exception {

        assertThat(digitsOfNumber(134)).containsOnly(1, 3, 4);
//        System.out.println(digitsOfNumber(897));

    }

    @Test
    public void testIsPandigital() throws Exception {
        assertThat(isPandigital(123, 3)).isTrue();
        assertThat(isPandigital(143, 3)).isFalse();
        assertThat(isPandigital(122, 3)).isFalse();
        assertThat(isPandigital(102, 3)).isFalse();
        assertThat(isPandigital(53, 3)).isFalse();
        assertThat(isPandigital(864975321, 9)).isTrue();

//        assertThat(isPandigital(123)).isTrue();
//        assertThat(isPandigital(143)).isFalse();
//        assertThat(isPandigital(122)).isFalse();
//        assertThat(isPandigital(102)).isFalse();
//        assertThat(isPandigital(53)).isFalse();
//        assertThat(isPandigital(864975321)).isTrue();
//        assertThat(isPandigital(4111)).isFalse();
//        assertThat(isPandigital(4211)).isFalse();

//        assertThat(isPandigital(123, 1, 3)).isTrue();
//        assertThat(isPandigital(143, 1, 3)).isFalse();
//        assertThat(isPandigital(122, 1, 3)).isFalse();
//        assertThat(isPandigital(102, 1, 3)).isFalse();
//        assertThat(isPandigital(53, 1, 3)).isFalse();
//        assertThat(isPandigital(864975321, 1, 9)).isTrue();
//        assertThat(isPandigital(4111, 1, 9)).isFalse();
//        assertThat(isPandigital(4211, 1, 9)).isFalse();
//
//
        assertThat(isNPandigital(123)).isTrue();
        assertThat(isNPandigital(123)).isTrue();
        assertThat(isNPandigital(143)).isFalse();
        assertThat(isNPandigital(122)).isFalse();
        assertThat(isNPandigital(102)).isFalse();
        assertThat(isNPandigital(53)).isFalse();
        assertThat(isNPandigital(864975321)).isTrue();
        assertThat(isNPandigital(4111)).isFalse();
        assertThat(isNPandigital(4211)).isFalse();
        assertThat(isNPandigital(1009)).isFalse();
        assertThat(isNPandigital(1007767)).isFalse();


    }

    @Test
    public void testIsPalindromee() throws Exception {
        assertThat(isPalindrome(4,10)).isTrue();
        assertThat(isPalindrome(44,10)).isTrue();
        assertThat(isPalindrome(121,10)).isTrue();
        assertThat(isPalindrome(1221,10)).isTrue();
        assertThat(isPalindrome(12121,10)).isTrue();
        assertThat(isPalindrome(12121,10)).isTrue();

        assertThat(isPalindrome(43,10)).isFalse();
        assertThat(isPalindrome(433,10)).isFalse();
        assertThat(isPalindrome(4233,10)).isFalse();

    }

    @Test
    public void testIsTruncatable() throws Exception {
        boolean[] primes = calculatePrimes2(1000000);
        assertThat(isTruncatableLR(3797, primes)).isTrue();
        assertThat(isTruncatableRL(3797, primes)).isTrue();

    }

    @Test
    public void testNextPerm() throws Exception {

        assertThat(nextPerm(Arrays.asList(1, 4, 8, 7))).isEqualTo(Arrays.asList(4, 8, 7, 1));

    }

    @Test
    public void testReverse() throws Exception {
        assertThat(reverse(132,10)).isEqualTo(231);
        assertThat(reverse(15436,10)).isEqualTo(63451);

    }

    @Test
    public void testSort() throws Exception {
        assertThat(sortInt(14423)).isEqualTo(44321);
        assertThat(sortInt(589064)).isEqualTo(986540);
    }

    @Test
    public void testConcatInts() throws Exception {

        assertThat(concatInts(132,54)).isEqualTo(13254);

    }
}
