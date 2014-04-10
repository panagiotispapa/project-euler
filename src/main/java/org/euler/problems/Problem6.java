package org.euler.problems;

public class Problem6 {

    public static void main(String[] args) {
        long sumSq = 0;
        long sum = 0;

        for (int i = 0; i <= 100; i++) {
            sumSq += (i * i);
            sum += i;
        }

        System.out.println(sumSq);
        System.out.println(sum);
        System.out.println(sum*sum - sumSq);

    }
}
