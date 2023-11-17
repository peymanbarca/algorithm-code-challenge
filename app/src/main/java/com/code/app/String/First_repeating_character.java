
/*

Given a string S consisting of lowercase Latin Letters. Return the first repeating character in S. If there is no repeating character, return '$'.


 */

import java.util.HashSet;

public class First_repeating_character {
    public static char firstNonRepeatingCharacter(String s) {
        HashSet<Character> seenCharacters = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!seenCharacters.add(c)) {
                return c; // Found the first repeating character
            }
        }

        // If no repeating character is found, return '$'
        return '$';
    }

    public static void main(String[] args) {
        String input = "abacabad";

        char result = firstNonRepeatingCharacter(input);

        System.out.println("The first non-repeating character is: " + result);
    }
}


/*
Let n be the length of the input string.
The algorithm iterates through the string once.
The time complexity is O(n).
The space complexity is O(n) in the worst case, where all characters in the string are unique. However,
    in practice, it can be considered O(1) since the size of the HashSet is bounded by the size of the alphabet (26 lowercase Latin letters).

 */