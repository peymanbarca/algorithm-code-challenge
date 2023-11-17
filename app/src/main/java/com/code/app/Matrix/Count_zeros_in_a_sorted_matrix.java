package com.code.app.Matrix;

/*
Given a N X N binary Square Matrix where each row and column of the matrix is sorted in ascending order. Find the total number of zeros present in the matrix.

 you can start from the top-right corner of the matrix and traverse the matrix based on the following rules:

If the current element is 0, then all elements to its left and below it are also zeros.
If the current element is 1, move to the left (since the column is sorted in ascending order).
If the current element is 0, move down (since the row is sorted in ascending order).

 */
public class Count_zeros_in_a_sorted_matrix {

    public static int countZeros(int[][] matrix) {
        int n = matrix.length;
        int count = 0;

        int row = 0;
        int col = n - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == 0) {
                // If the current element is 0, all elements to its left and below are also zeros
                count += col + 1;
                row++;
            } else {
                // If the current element is 1, move to the left
                col--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0},
                {0, 0, 1, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        };

        int result = countZeros(matrix);

        System.out.println("Total number of zeros in the matrix: " + result);
    }
}

/*
Asymptotic analysis:

Let N be the size of the matrix (N x N).
The algorithm iterates through the matrix at most twice (once for each row and once for each column).
The time complexity is O(N).
The space complexity is O(1) as the algorithm uses a constant amount of extra space.
 */