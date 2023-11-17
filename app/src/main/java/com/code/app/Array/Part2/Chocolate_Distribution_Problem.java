package com.code.app.Array.Part2;

/*

Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.

you can sort the array of chocolates and then find the minimum difference between the maximum and minimum number
    of chocolates given to a student by iterating through the sorted array.

 */

import java.util.Arrays;

public class Chocolate_Distribution_Problem {

    public static int distributeChocolates(int[] A, int M) {
        if (A == null || A.length == 0 || M <= 0) {
            return -1; // Invalid input
        }

        int N = A.length;

        if (M > N) {
            return -1; // More students than chocolates, cannot distribute
        }

        Arrays.sort(A); // Sort the array

        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i + M - 1 < N; i++) {
            int difference = A[i + M - 1] - A[i];
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

    public static void main(String[] args) {
        int[] chocolates = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int students = 7;

        int result = distributeChocolates(chocolates, students);

        System.out.println("Minimum difference between the maximum and minimum chocolates: " + result);
    }

}


/*

Asymptotic analysis:

Let N be the length of the array A.
Sorting the array takes O(N log N) time.
Iterating through the sorted array takes O(N) time.
The overall time complexity is dominated by the sorting step, so it is O(N log N).
The space complexity is O(1) as we only use a constant amount of extra space.

 */