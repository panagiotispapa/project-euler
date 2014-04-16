package org.euler.problems;

import java.util.Arrays;

import static org.euler.util.Tools.addNumberTo;
import static org.euler.util.Tools.strValueTrimZeros;

public class Problem25 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        int[] fibo = new int[3000];
        int[] fiboPrev = new int[3000];

        fibo[0] = 1;
        fiboPrev[0] = 1;

        int index = 2;

        while (strValueTrimZeros(fibo).length() < 1000) {



            int[] temp = Arrays.copyOf(fibo, fibo.length);
            addNumberTo(fibo, fiboPrev);
            fiboPrev = Arrays.copyOf(temp, temp.length);
            index++;

//            System.out.println(index + ", " + strValueTrimZeros(fibo));
        }

        System.out.println(index);
        System.out.println(strValueTrimZeros(fibo));


        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }
}
