package com.code.app.String;

/*
Given a string, find the longest substring which is palindrome in Linear time O(N).
 If there are multiple such substrings of same length, print the one which appears first in the input string.
 */

public class Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] extendedString = preprocess(s);
        int[] palindromeLengths = new int[extendedString.length];

        int center = 0, rightBoundary = 0;
        int maxCenter = 0, maxPalindromeLength = 0;

        for (int i = 1; i < extendedString.length - 1; i++) {
            int mirror = 2 * center - i;

            if (i < rightBoundary) {
                palindromeLengths[i] = Math.min(rightBoundary - i, palindromeLengths[mirror]);
            }

            // Attempt to expand palindrome centered at i
            while (extendedString[i + (1 + palindromeLengths[i])] == extendedString[i - (1 + palindromeLengths[i])]) {
                palindromeLengths[i]++;
            }

            // If palindrome centered at i expands past rightBoundary, adjust center and rightBoundary
            if (i + palindromeLengths[i] > rightBoundary) {
                center = i;
                rightBoundary = i + palindromeLengths[i];
            }

            // Update the longest palindrome if necessary
            if (palindromeLengths[i] > maxPalindromeLength) {
                maxPalindromeLength = palindromeLengths[i];
                maxCenter = i;
            }
        }

        int start = (maxCenter - maxPalindromeLength) / 2;
        int end = start + maxPalindromeLength;

        return s.substring(start, end);
    }

    private static char[] preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$#");

        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }

        sb.append('^');
        return sb.toString().toCharArray();
    }

    public static void main(String[] args) {
        String input = "babad";

        String result = longestPalindrome(input);

        System.out.println("Longest palindrome substring: " + result);
    }
}



/*

Asymptotic analysis:

Let n be the length of the input string.
Manacher's algorithm performs a linear scan of the extended string (of length 2n+3) once.
The time complexity is O(n).
The space complexity is O(n) for the extended string and additional arrays.

 */