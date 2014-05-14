package org.euler.problems;

import org.euler.util.Tools;

import java.util.List;

public class Problem40 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int max = 0;

        int[] champ = new int[10000000];

        int index = 0;

        for (int i = 0; i < 100000000 && index < champ.length; i++) {
            List<Integer> digits = Tools.digitsOfNumber(i);

            int size = digits.size();
            for (int j = 0; j < size && index < champ.length; j++) {
                champ[index++] = digits.get(size - 1 - j);
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(champ[i]);
        }

        System.out.println();
        System.out.println(champ[9 - 1]);
        System.out.println(champ[10 - 1]);
        System.out.println(champ[11 - 1]);
        System.out.println(champ[12 - 1]);

        System.out.println("--");

//        System.out.println(champ[1 - 1]);
//        System.out.println(champ[10 - 1]);
//        System.out.println(champ[100 - 1]);
//        System.out.println(champ[1000 - 1]);
//        System.out.println(champ[10000 - 1]);
//        System.out.println(champ[100000 - 1]);
//        System.out.println(champ[1000000 - 1]);

        System.out.println(champ[1 - 1] * champ[10-1] * champ[100-1] * champ[1000-1] * champ[10000-1] * champ[100000-1]);

//        System.out.println(champ);

        System.out.println("max " + max);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    //private static String

}
