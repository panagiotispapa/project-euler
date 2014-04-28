package org.euler.problems;

import com.google.common.collect.Lists;

import java.util.List;

import static org.euler.util.Tools.isAbundant;

public class Problem23 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        List<Integer> abundantNumbers = Lists.newArrayList();

        boolean[] canBe = new boolean[28124];

        for (int i = 1; i < 28124; i++) {
            if (isAbundant(i)) {
                abundantNumbers.add(i);
//                System.out.println(i);
            }
        }

        System.out.println(abundantNumbers);

        combinationsKofNWithDuplicates(abundantNumbers, canBe, new int[2], 0);


        long sum = 0;
        for (int i = 0; i < canBe.length; i++) {
            if(!canBe[i]) {
//                System.out.println(i);
                sum+=i;
            }
        }


//        System.out.println(combinationsKofN(abundantNumbers, 2, true));
//        System.out.println(abundantNumbers.size());
//        System.out.println(combinationsWithRepetitionCnt(6965, 2));

        System.out.println(sum);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    private static void combinationsKofNWithDuplicates(List<Integer> items, boolean[] canBe, int[] selections, int index) {
        if (index == selections.length) {
            int sum = 0;
            for (int selection : selections) {
                sum += items.get(selection);
            }

            if (sum < canBe.length) {
                canBe[sum] = true;
            }

        } else {
            final int start = index > 0 ? selections[index - 1] : 0;
            for (int i = start; i < items.size(); i++) {
                selections[index] = i;
                combinationsKofNWithDuplicates(items, canBe, selections, index + 1);
            }
        }

    }

}
