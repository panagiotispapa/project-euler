package org.euler.problems;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.euler.util.Alphabet.wordSum;

public class Problem22 {

    public static void main(String[] args) throws IOException {

        long now = System.currentTimeMillis();

        List<String> lines = FileUtils.readLines(new File("d:/names.txt"));

        String[] wordsInit = lines.get(0).split(",");

        List<String> words = Lists.newArrayList();
        for (String word : wordsInit) {
            words.add(word.replaceAll("\"",""));
        }

        Collections.sort(words);
//        System.out.println(words.size());
//
        System.out.println(words);

        long sum = 0;
        int index = 1;
        for (String word : words) {
//            if(word.equalsIgnoreCase("COLIN")){
//                System.out.println("------------- " + index);
//            }

            sum += index * wordSum(word);
            index++;
        }

        System.out.println("sum " + sum);

//        Collections.sort(Arrays.asList(words));
//

        System.out.println("time required: " + (System.currentTimeMillis() - now));

    }

}
