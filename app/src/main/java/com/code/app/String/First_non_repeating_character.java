
/*

Given a string S consisting of lowercase Latin Letters. Return the first non-repeating character in S. If there is no non-repeating character, return '$'.

you can use a HashMap to store the frequency of each character in the string and then iterate through the string to find the first character with a frequency of 1.

 */

import java.util.HashMap;

public class First_non_repeating_character {
    public static char firstNonRepeatingCharacter(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a frequency of 1
        for (char c : s.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c;
            }
        }

        // If no non-repeating character is found, return '$'
        return '$';
    }

    public static void main(String[] args) {
        String input = "abacabad";

        char result = firstNonRepeatingCharacter(input);

        System.out.println("The first non-repeating character is: " + result);
    }
}


/*

The algorithm iterates through the string twice: once to build the frequency map and once to find the first non-repeating character.
The time complexity is O(n).
The space complexity is O(1) because the size of the alphabet (26 lowercase Latin letters) is constant.
 */