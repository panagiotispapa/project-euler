package org.euler.problems;

import com.google.common.collect.Sets;
import org.euler.util.Tools;

import java.util.TreeSet;

import static org.euler.util.Tools.sortLong;

public class Problem38 {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();

        TreeSet<String> set = Sets.newTreeSet();

        for (int i = 1; i < 100000000; i++) {
            StringBuilder builder = new StringBuilder();

            for (int j = 1; j < 10; j++) {
                builder.append(i * j);

                if (builder.charAt(0) != '9') {
                    break;
                }

                if (builder.length() > 9) {
                    break;
                } else if (builder.length() == 9) {
                    String number = builder.toString();
                    if (Tools.isPandigital(number, 9)) {
                        System.out.println(number);
                        set.add(number);
                    } else {
                        break;
                    }

                }
            }
        }

//        918273645
//        926718534
//        927318546
//        932718654
//        max 932718654
//        time required: 11932


        System.out.println("max " + set.last());
        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }



//    private static boolean isPandigital(long n) {
//
//        return sortLong(n) == 987654321;
//
//    }


    //private static String

}
