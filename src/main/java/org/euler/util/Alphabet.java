package org.euler.util;

import org.apache.commons.lang.StringUtils;

import static java.lang.Character.getNumericValue;
import static java.lang.String.valueOf;

public class Alphabet {

    private static final int A = getNumericValue('A');

    public static int wordSum(String word) {
        String w = word.toUpperCase();

        int sum = 0;

        for (int i = 0; i < w.length(); i++) {

            if(StringUtils.isAlphanumeric(valueOf(w.charAt(i)))){
                sum += getNumericValue(w.charAt(i)) - A + 1;
            }

//            System.out.println(getNumericValue(w.charAt(i)) - A + 1);
        }
        return sum;
    }

}
