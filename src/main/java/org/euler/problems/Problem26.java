package org.euler.problems;

public class Problem26 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        int max = 0;
        int d = 0;
        for (int i = 2; i < 1001; i++) {
//            BigDecimal b = BigDecimal.ONE.divide(new BigDecimal(i), 70, RoundingMode.CEILING);

            int[] decimals = calculateUnitFraction(i);
            int repeatingCnt = calculateRepeatingCnt(decimals,i);
            System.out.println(i + " " + repeatingCnt);
            if (repeatingCnt > max) {
                max = repeatingCnt;
                d = i;
            }

        }

        System.out.println(max + " for " + d);
//        System.out.println("i 14" + " " + calculateUnitFraction(14));
//
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static int calculateRepeatingCnt(int[] decimals, int d) {

        int half = decimals.length / 2;

        int windowSize = 1;
        if (d > 100) {
            windowSize = 2;
        }
        for (int offset = 0; offset < half - 2; offset++) {
            for (; windowSize < half - offset; windowSize++) {
                int repeatingCnt = calculateRepeatingCnt(decimals, offset, windowSize);
                if (repeatingCnt > 0) {
                    return repeatingCnt;
                }
            }
        }

        return 0;
    }

    private static int calculateRepeatingCnt(int[] decimals, int offset, int windowSize) {
        for (int i = 0; i < windowSize; i++) {
            if (decimals[i + offset] != decimals[i + windowSize + offset])
                return 0;
        }

        return windowSize;

    }

    private static int[] calculateUnitFraction(int denominator) {

        int current = 10;
        int index = 0;

        int MAX = 10000;

        int[] decimals = new int[MAX];
        while (current % denominator != 0 && index < MAX) {
//            System.out.print(current / denominator);
            decimals[index] = current / denominator;
            current = (current % denominator) * 10;

            index++;
        }

        if (index < MAX) {
            decimals[index] = current / denominator;
        }

        return decimals;
    }







    private static void print(int[] numbers) {
        for (int n : numbers) {
            System.out.print(n);
        }
        System.out.println();
    }

}
