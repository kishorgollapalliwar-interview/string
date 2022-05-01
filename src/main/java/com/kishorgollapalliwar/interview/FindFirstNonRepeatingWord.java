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
        String input = "JAVA is not javaSCRIPT. But syntax of javascript is very close JAVA.";
        String temp = input.replace(".", "");
        String [] inputArray = temp.split(" ");
        boolean isCaseSensitiveCheck = false;

        String firstNonRepeatingWord = findFirstNonRepeatingWord(inputArray, isCaseSensitiveCheck);
        System.out.println("First Non Repeating word is " + firstNonRepeatingWord);
    }

    /**
     * Find first non repeating word.
     * Current time complexity O(2n)
     * @param strArray
     * @return first non repeating word if present, {@code null} otherwise.
     */
    public static String findFirstNonRepeatingWord(String [] strArray, boolean isCaseSensitiveCheck) {//FIXME isCaseSensitiveCheck never used
        String nonRepeatingStr = null;
        Map<String, Integer> map = new HashMap<>();

        //preparation
        for(String currentStr : strArray) {
            Integer count = map.get(currentStr);

            if (Objects.isNull(count)) {
                count = 0;
            }
            count++;

            map.put(currentStr, count);
        }

        //find
        for(String currentStr : strArray) {
            Integer count = map.get(currentStr);
            if (count == 1) {
                nonRepeatingStr = currentStr;
                break;
            }
        }

        return nonRepeatingStr;
    }
}
