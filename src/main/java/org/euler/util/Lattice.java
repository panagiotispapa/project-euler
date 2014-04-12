package org.euler.util;

import java.util.Map;

public class Lattice {

    public static void countRoutes(int height, int remaining, long[] totalFound, Map<Integer, Long> map) {
//        System.out.println(height + " " + remaining);
        if (remaining == 1) {
            totalFound[0] += height;
        } else {
            for (int i = height; i >= 1; i--) {
//                System.out.println("i " + i + " r " + remaining);

                if (i == remaining + 1) {
                    Long savedResult = map.get(i);
//                    System.out.println("here! " + i + " " + savedResult);

                    if (savedResult != null) {
                        totalFound[0] += savedResult;
                        break;
                    } else {
                        countRoutes(i, remaining - 1, totalFound, map);
                    }

//                    System.out.println();

//                    if(map.get(i)!=null){
//                        System.out.println(map);
//                    }

                } else {
                    countRoutes(i, remaining - 1, totalFound, map);
                }

            }

        }

    }

}
