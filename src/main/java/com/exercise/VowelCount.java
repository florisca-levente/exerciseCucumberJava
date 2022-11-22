package com.exercise;

import java.util.*;

public class VowelCount {
    public static Object main(String[] args) {
        if (args.length >= 4) {//corrected, should be strictly larger, index starts from 0, count starts from 1, args.length > 4
            System.out.println("Extra arguments passed.");
            //I suggest a more user friendly message, informing the user about the max input number
            //You have exceeded the maximum number of 4 arguments.
            return null;
        } else {
            Map<String, Map<Integer, Integer>> vowelCount = new LinkedHashMap<>();
            //I suggest LinkedHashMap, it returns the items in the order you've entered them,
            // opposed to HashMap, where the order is not guaranteed
            List<String> argumentList = Arrays.asList(args);
            argumentList.forEach(argument -> vowelCount.put(argument, getVowelAndConsonantCount(argument)));
            //Do we need the name? According to the docs we want the number of vowels and consonants, no mention of input value.
//            System.out.println(vowelCount);
            return vowelCount;
        }
    }

    private static Map<Integer, Integer> getVowelAndConsonantCount(String input) {
        String[] inputChars = input.toLowerCase().split(""); //added lower case support
        Map<Integer, Integer> consonantAndVowelCount = new LinkedHashMap<>();
        consonantAndVowelCount.put(
                (int) Arrays.stream(inputChars).filter(inputChar -> inputChar.matches("[b-df-hj-np-tv-z]")).count(),
                (int) Arrays.stream(inputChars).filter(inputChar -> inputChar.matches("[aeiou]")).count()
        );
        return consonantAndVowelCount;
    }
}