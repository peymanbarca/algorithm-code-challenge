package com.code.app.Matrix;

/*
Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.
Input:
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2

 starting from the top-right corner of the matrix and moving left or down based on the presence of 1 or 0.

 */

public class Find_the_row_with_maximum_number_of_1s {
    public static int findMaxOnesRowIndex(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxOnesCount = 0;
        int maxOnesRowIndex = -1;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == 1) {
                maxOnesCount = m - col;
                maxOnesRowIndex = row;
                col--;
            } else {
                row++;
            }
        }

        return maxOnesRowIndex;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        };

        int result = findMaxOnesRowIndex(matrix);

        System.out.println("Index of the row with the maximum number of 1's: " + result);
    }

}

/*

Let n be the number of rows and m be the number of columns in the matrix.
The algorithm starts from the top-right corner and moves left or down until the maximum number of 1's in a row is found.
The time complexity is O(N + M) since each row and each column are traversed at most once.
The space complexity is O(1) as the algorithm uses a constant amount of extra space.

 */