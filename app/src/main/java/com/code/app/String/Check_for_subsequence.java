

/*
Given two strings A and B, find if A is a subsequence of B.
 */


public class Check_for_subsequence {
    public static boolean isSubsequence(String A, String B) {
        int i = 0, j = 0;

        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == A.length();
    }

    public static void main(String[] args) {
        String A = "abc";
        String B = "aabbcc";

        boolean result = isSubsequence(A, B);

        if (result) {
            System.out.println(A + " is a subsequence of " + B);
        } else {
            System.out.println(A + " is not a subsequence of " + B);
        }
    }
}


/*

Asymptotic analysis:

Let n be the length of string A and m be the length of string B.
The algorithm iterates through both strings once.
The time complexity is O(n + m), where n and m are the lengths of strings A and B, respectively.
The space complexity is O(1) since the algorithm uses a constant amount of extra space.

 */