package com.kishorgollapalliwar.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Problem: Find first non repeating character from given string/ char array
 * @author kishor
 *
 */
public class FindFirstNonRepeatingChar {
    public static void main(String[] args) {
        /*
         * Input: If you already have char array then good, otherwise convert sting into char array 
         */
        String input = "JAVA is not javaSCRIPT";
        char [] inputArray = input.toCharArray();
        boolean isCaseSensitiveCheck = false;

        Character firstNonRepeatingChar = findFirstNonRepeatingChar(inputArray, isCaseSensitiveCheck);
        System.out.println("First Non Repeating Character is " + firstNonRepeatingChar);
    }

    /**
     * Find first non repeating character.
     * Current time complexity O(2n)
     * @param charArray
     * @param isCaseSensitiveCheck
     * @return first non repeating character if present, {@code null} otherwise.
     */
    public static Character findFirstNonRepeatingChar(char [] charArray, boolean isCaseSensitiveCheck) {
        Character nonRepeatingChar = null;
        Map<Character, Integer> map = new HashMap<>();

        //preparation
        for(Character currentChar : charArray) {
            Character temp = isCaseSensitiveCheck ? currentChar : Character.toLowerCase(currentChar);
            Integer count = map.get(temp);

            if (Objects.isNull(count)) {
                count = 0;
            }
            count++;

            map.put(temp, count);
        }

        //find
        for(Character currentChar : charArray) {
            Character temp = isCaseSensitiveCheck ? currentChar : Character.toLowerCase(currentChar);
            Integer count = map.get(temp);
            if (count == 1) {
                nonRepeatingChar = currentChar;
                break;
            }
        }

        return nonRepeatingChar;
    }
}
