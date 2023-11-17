
/*
Given two strings A and B consisting of lowercase english characters. Find the characters that are not common in the two strings.

you can use a HashSet to store the unique characters of each string.
Then, iterate through both strings to find characters that are present in only one of the strings.

 */

import java.util.HashSet;
import java.util.Set;

public class Uncommon_characters {
    public static String findNonCommonCharacters(String A, String B) {
        Set<Character> setA = new HashSet<>();
        Set<Character> setB = new HashSet<>();

        // Add characters from string A to setA
        for (char c : A.toCharArray()) {
            setA.add(c);
        }

        // Add characters from string B to setB
        for (char c : B.toCharArray()) {
            setB.add(c);
        }

        // Find characters that are in setA but not in setB, and vice versa
        Set<Character> nonCommonCharacters = new HashSet<>(setA);
        nonCommonCharacters.addAll(setB);
        Set<Character> commonCharacters = new HashSet<>(setA);
        commonCharacters.retainAll(setB);

        nonCommonCharacters.removeAll(commonCharacters);

        // Convert the set of non-common characters to a string
        StringBuilder result = new StringBuilder();
        for (char c : nonCommonCharacters) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdefg";

        String result = findNonCommonCharacters(A, B);

        System.out.println("Non-common characters: " + result);
    }
}
