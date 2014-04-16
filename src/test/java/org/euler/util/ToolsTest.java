package org.euler.util;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Arrays.binarySearch;
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
    public void testPermutationsChar() throws Exception {
        assertThat(permutationsChar(new char[]{'0','1','2'})).containsOnly(
                "012",
                "021",
                "102",
                "120",
                "201",
                "210"
        );

    }
}
