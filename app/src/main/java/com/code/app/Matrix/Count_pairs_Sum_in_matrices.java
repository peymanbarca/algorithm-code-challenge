package com.code.app.Matrix;

/*
Given two sorted matrices mat1 and mat2 of size N x N of elements.
 Given a value x. The problem is to count all pairs from both matrices whose sum is equal to x.

Input:
N = 3, x = 21
mat1 = { {1 5 6}
         {8 10 11}
         {15 16 18} }
mat2 = { {2 4 7}
         {9 10 12}
         {13 16 20} }
OUTPUT: 4
Explanation: The pairs are (1, 20),
            (5, 16), (8, 13), (11, 10).

To count all pairs from two sorted matrices whose sum is equal to a given value x,
    you can use a two-pointer approach. Initialize one pointer at the bottom-left corner of the first matrix (mat1)
    and another pointer at the top-right corner of the second matrix (mat2).
    Then, move the pointers based on the sum of the elements at their positions.

 */

public class Count_pairs_Sum_in_matrices {

    public static int countPairs(int[][] mat1, int[][] mat2, int x) {
        int count = 0;
        int n = mat1.length;
        int i = n - 1; // Start from the bottom row of mat1
        int j = 0;    // Start from the first column of mat2

        while (i >= 0 && j < n) {
            int sum = mat1[i][j] + mat2[i][j];

            if (sum == x) {
                count++;
                i--; // Move to the above row in mat1
            } else if (sum < x) {
                j++; // Move to the right column in mat2
            } else {
                i--; // Move to the above row in mat1
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 5, 7},
                {3, 7, 9},
                {5, 9, 11}
        };

        int[][] mat2 = {
                {2, 6, 8},
                {4, 8, 10},
                {6, 10, 12}
        };

        int x = 16;

        int result = countPairs(mat1, mat2, x);

        System.out.println("Number of pairs with sum " + x + ": " + result);
    }
}



/*
Asymptotic analysis:

Let N be the size of the matrices (N x N).
The algorithm iterates through the matrices once.
The time complexity is O(N) as the number of iterations is linear with respect to the size of the matrices.
The space complexity is O(1) as the algorithm uses a constant amount of extra space.

 */