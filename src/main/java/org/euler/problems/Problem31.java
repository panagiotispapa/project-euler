package org.euler.problems;

import java.util.List;

public class Problem31 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        int total = 0;

        int lim1 = 200 / 200;
        int lim2 = 200 / 100;
        int lim3 = 200 / 50;
        int lim4 = 200 / 20;
        int lim5 = 200 / 10;
        int lim6 = 200 / 5;
        int lim7 = 200 / 2;
        int lim8 = 200;

        for (int i1 = 0; i1 <= lim1; i1++) {
            for (int i2 = 0; i2 <= lim2; i2++) {
                if (i1 * 200 + i2 * 100 > 200) {
                    continue;
                }
                for (int i3 = 0; i3 <= lim3; i3++) {
                    if (i1 * 200 + i2 * 100 + i3 * 50 > 200) {
                        continue;
                    }
                    for (int i4 = 0; i4 <= lim4; i4++) {
                        if (i1 * 200 + i2 * 100 + i3 * 50 + i4 * 20 > 200) {
                            continue;
                        }

                        for (int i5 = 0; i5 <= lim5; i5++) {
                            if (i1 * 200 + i2 * 100 + i3 * 50 + i4 * 20 + i5 * 10 > 200) {
                                continue;
                            }

                            for (int i6 = 0; i6 <= lim6; i6++) {
                                if (i1 * 200 + i2 * 100 + i3 * 50 + i4 * 20 + i5 * 10 + i6 * 5 > 200) {
                                    continue;
                                }
                                for (int i7 = 0; i7 <= lim7; i7++) {
                                    if (i1 * 200 + i2 * 100 + i3 * 50 + i4 * 20 + i5 * 10 + i6 * 5 + i7 * 2 > 200) {
                                        continue;
                                    }

                                    for (int i8 = 0; i8 <= lim8; i8++) {
                                        int value = i1 * 200 + i2 * 100 + i3 * 50 + i4 * 20 + i5 * 10 + i6 * 5 + i7 * 2 + i8;
                                        if (value == 200) {
//                                            System.out.println(i1 + " " + i2 + " " + i3);
                                            total++;

                                        }

                                        if (value > 200) {
                                            continue;
                                        }

                                    }

                                }

                            }

                        }

                    }
                }
            }

        }

        System.out.println("total " + total);

//        System.out.println(combs);

//        System.out.println(combinationsKofN(items, 11, true));

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static int calcSumb(List<Integer> values) {
        int sum = 0;
        for (Integer number : values) {
            sum += number;
        }
        return sum;

    }

}
