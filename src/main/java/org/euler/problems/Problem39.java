package org.euler.problems;

public class Problem39 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        int max = 0;

        int[] squares = new int[10000];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = i * i;
        }

        int times;
        int maxValue = 0;

        for (int p = 3; p <= 1000; p++) {
//            System.out.println(p);
            times = 0;
            for (int i = 1; i < p; i++) {
                for (int j = i; j < p - i; j++) {
                    if (squares[p - i - j] == squares[i] + squares[j]) {
//                        System.out.println(i + " " + j + " " + (p - i - j));
                        times++;
                    }
                }
            }
            if (times > max) {
                max = times;
                maxValue = p;
            }
        }

        System.out.println("max " + max + " maxValue " + maxValue);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

    //private static String

}
