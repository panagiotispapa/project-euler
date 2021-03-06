package org.euler.problems;

import com.google.common.collect.Maps;

import java.util.Map;

import static org.euler.util.Lattice.countRoutes;

public class Problem15 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        Map<Integer, Long> map = Maps.newHashMap();

        map.put(3, 6L);
        map.put(4, 20L);
        map.put(5, 70L);
        map.put(6, 252L);
        map.put(7, 924L);
        map.put(8, 3432L);
        map.put(9, 12870L);
        map.put(10, 48620L);
        map.put(11, 184756L);
        map.put(12, 705432L);
        map.put(13, 2704156L);
        map.put(14, 10400600L);
        map.put(15, 40116600L);
        map.put(16, 155117520L);
        map.put(17, 601080390L);
        map.put(18, 2333606220L);
        map.put(19, 9075135300L);
        map.put(20, 35345263800L);



        int max = 20;
        int height = max + 1;
        long[] total = new long[]{0};

        countRoutes(height, max, total,map);

        System.out.println(total[0]);

//        137846528820
//        time required: 119 923

//        137846528820
//        time required: 228 966


//        137846528820
//        time required: 1 895 331

        System.out.println("time required: " + (System.currentTimeMillis() - now));
    }

}
