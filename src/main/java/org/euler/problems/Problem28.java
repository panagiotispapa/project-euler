package org.euler.problems;

public class Problem28 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        long sum = 1;
        int current = 1;

        for (int step = 1; step < 1001; step += 2) {
            for (int i = 0; i < 4; i++) {
                current += (step + 1);
                sum += (current);
//                System.out.println(current);
            }
        }

        System.out.println(sum);
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
