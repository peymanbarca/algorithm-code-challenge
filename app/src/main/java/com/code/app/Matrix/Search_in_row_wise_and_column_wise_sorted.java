package com.code.app.Matrix;

/*
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order,
and a number X is given. The task is to find whether element X is present in the matrix or not.

you can start from the top-right corner of the matrix and move left or down based on the comparison of the current element with the target value X.

 */

public class Search_in_row_wise_and_column_wise_sorted {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Element found
            } else if (matrix[row][col] < target) {
                // Move to the next row (since the current row is sorted)
                row++;
            } else {
                // Move to the previous column (since the current column is sorted)
                col--;
            }
        }

        return false; // Element not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 5;

        boolean result = searchMatrix(matrix, target);

        if (result) {
            System.out.println("Element " + target + " is present in the matrix.");
        } else {
            System.out.println("Element " + target + " is not present in the matrix.");
        }
    }
}



/*
Let N be the number of rows and M be the number of columns in the matrix.
The algorithm starts from the top-right corner and moves left or down until the target value is found or the boundary is reached.
The time complexity is O(N + M) since each row and each column are traversed at most once.
The space complexity is O(1) as the algorithm uses a constant amount of extra space.
 */