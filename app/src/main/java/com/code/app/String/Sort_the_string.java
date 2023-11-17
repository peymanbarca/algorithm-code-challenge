
/*
Given a string str containing only lower case alphabets, the task is to sort it in lexicographically-descending order.
 */

import java.util.Arrays;

public class Sort_the_string {
    public static String sortDescending(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Sort the character array in descending order
        Arrays.sort(charArray);
        reverse(charArray);

        // Create a new string from the sorted array
        return new String(charArray);
    }

    // Helper function to reverse a character array
    private static void reverse(char[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String input = "zyxwvu";

        String result = sortDescending(input);

        System.out.println("Lexicographically-descending order: " + result);
    }
}

/*

Asymptotic analysis:

Let n be the length of the input string.
The algorithm first converts the string to a character array, which takes O(n) time.
Sorting the character array using Arrays.sort has a time complexity of O(n log n).
Reversing the character array has a time complexity of O(n).
The overall time complexity is dominated by the sorting step, so the total time complexity is O(n log n).
The space complexity is O(n) for the character array.

 */