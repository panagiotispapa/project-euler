package org.euler.problems;

import org.euler.util.Tools;

import java.util.Collections;
import java.util.List;

public class Problem24 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        List<String> perms = Tools.permutationsChar(new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'});

        Collections.sort(perms);

        long index = 1;

        for (String perm : perms) {
            if (index == 1000000) {
                System.out.println(perm);
            }
            index++;
        }

//        for (int i = 0; i < perms.size(); i++) {
//            System.out.printf("%4d: %s%n", i, perms.get(i));
//        }

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
