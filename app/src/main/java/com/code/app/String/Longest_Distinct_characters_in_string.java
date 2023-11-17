
/*
Given a string S, find the length of the longest substring with all distinct characters.

Input:
S = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest
substring with all distinct characters.

o solve this problem in Java, you can use the sliding window technique.
Maintain a set to keep track of unique characters within the current window and update the window boundaries accordingly.

 */

import java.util.HashSet;
import java.util.Set;

public class Longest_Distinct_characters_in_string {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();

        int left = 0;
        int right = 0;

        while (right < n) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";

        int result = lengthOfLongestSubstring(input);

        System.out.println("Length of the longest substring with all distinct characters: " + result);
    }
}

/*
Asymptotic analysis:

Let n be the length of the input string.
The algorithm uses two pointers (left and right) to iterate through the string once.
The time complexity is O(n) because each character is visited at most twice (once by the right pointer and once by the left pointer).
The space complexity is O(min(n, m)), where m is the size of the character set (26 for lowercase English letters).
 In the worst case, the entire string is unique, and the set will store up to n characters.
 */