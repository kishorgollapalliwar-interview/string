package com.kishorgollapalliwar.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Problem: Find first non repeating word from given string
 * @author kishor
 *
 */
public class FindFirstNonRepeatingWord {
    public static void main(String[] args) {
        String input = "JAVA is not javaSCRIPT. But syntax of javascript is very close java. Not all programming languages are as good as Java.";

        String temp = input.replaceAll("[^a-zA-Z\s]+", ""); //remove all special characters (except space)
        String [] inputArray = temp.split(" ");
        boolean isCaseSensitiveCheck = false;

        String firstNonRepeatingWord = findFirstNonRepeatingWord(inputArray, isCaseSensitiveCheck);
        System.out.println("First Non Repeating = " + firstNonRepeatingWord);
    }

    /**
     * Find first non repeating word.
     * Current time complexity O(2n)
     * @param strArray
     * @return first non repeating word if present, {@code null} otherwise.
     */
    public static String findFirstNonRepeatingWord(String [] strArray, boolean isCaseSensitiveCheck) {
        String nonRepeatingStr = null;
        Map<String, Integer> map = new HashMap<>();

        //preparation
        for(String currentStr : strArray) {
            String temp = currentStr.toLowerCase();
            Integer count = map.get(temp);

            if (Objects.isNull(count)) {
                count = 0;
            }
            count++;

            map.put(temp, count);
        }

        //find
        for(String currentStr : strArray) {
            String temp = currentStr.toLowerCase();
            Integer count = map.get(temp);
            if (count == 1) {
                nonRepeatingStr = currentStr;
                break;
            }
        }

        return nonRepeatingStr;
    }
}
