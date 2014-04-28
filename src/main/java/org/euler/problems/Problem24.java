package org.euler.problems;

import org.euler.util.Tools;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem24 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        List<Integer> items = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<List<Integer>> perms = Tools.permutationsKofN(items, items.size(), false);

        System.out.println(perms.get(1000000-1));

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
