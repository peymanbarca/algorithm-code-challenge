package com.code.app.Matrix;

/*
Given a mxn matrix, count the number of squares in the matrix.


To count the number of squares in an mxn matrix, you can iterate through each cell in the matrix and consider
 it as the top-left corner of a square. For each such cell, check how many squares can be formed with that cell
 as the top-left corner. The total count will be the sum of squares formed for all cells.

 */

public class Squares_in_a_Matrix {

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        // Iterate through each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell contains 1, it can be the top-left corner of a square
                if (matrix[i][j] == 1) {
                    // Check how many squares can be formed with this cell as the top-left corner
                    count += countSquaresWithCellAsTopLeft(matrix, i, j);
                }
            }
        }

        return count;
    }

    private static int countSquaresWithCellAsTopLeft(int[][] matrix, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        // Check the maximum possible size of the square starting from the current cell
        int maxSize = Math.min(m - row, n - col);

        // Iterate through possible square sizes
        for (int size = 1; size <= maxSize; size++) {
            boolean isSquare = true;

            // Check if all cells in the square are 1
            for (int i = row; i < row + size; i++) {
                for (int j = col; j < col + size; j++) {
                    if (matrix[i][j] == 0) {
                        isSquare = false;
                        break;
                    }
                }
                if (!isSquare) {
                    break;
                }
            }

            // If all cells in the square are 1, increment the count
            if (isSquare) {
                count++;
            } else {
                // Break if a square cannot be extended further
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        int result = countSquares(matrix);

        System.out.println("Number of squares in the matrix: " + result);
    }
}

/*

Asymptotic analysis:

Let m be the number of rows and n be the number of columns in the matrix.
The algorithm iterates through each cell once, and for each cell, it may check at most min(m, n) square sizes.
The time complexity is O(m * n * min(m, n)).
The space complexity is O(1) as the algorithm uses a constant amount of extra space.

 */