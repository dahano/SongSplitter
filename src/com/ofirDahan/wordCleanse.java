package com.ofirDahan;

import java.util.*;

public class wordCleanse {

    public static Map<String, Integer> wordCounter = new TreeMap<>();

    public static Set<String> articleRemover(){

        Set<String> articleSet = new TreeSet<>();

        articleSet.add("a");
        articleSet.add("and");
        articleSet.add("ain't");

        return articleSet;
    }


    public static  Map<String, Integer> wordMap(String line, Set<String> articleRemover) {

        String[] splitText = line.toLowerCase().split("([^a-zA-Z']+)'*\\1*");

        List<String> word = Arrays.asList(splitText);


        for(String s: word){
            if(s.length() >= 2 && !articleRemover.contains(s)) {
                if (wordCounter.containsKey(s)) {
                    int currentValue = wordCounter.get(s);
                    currentValue++;
                    wordCounter.put(s, currentValue);
                } else {
                    wordCounter.put(s, 1);
                }
            }
        }

        return wordCounter;
    }

}
