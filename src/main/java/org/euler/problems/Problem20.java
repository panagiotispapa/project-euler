package org.euler.problems;

import static org.euler.util.Tools.addDigits;
import static org.euler.util.Tools.factorialBig;
import static org.euler.util.Tools.power;

public class Problem20 {

    public static void main(String[] args) {

        long now = System.currentTimeMillis();

        System.out.println(addDigits(factorialBig(100)));

        System.out.println("time required: " + (System.currentTimeMillis() - now));
        int t = 75+95+47+87+82+75+73+28+83+47+43+73+91+67+98;
        System.out.println(t);


    }

}
