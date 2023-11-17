package com.code.app.Matrix;
/*

Given a matrix of size N x N. Print the elements of the matrix in the Z like pattern
 */

public class Print_Matrix_in_Z_Pattern {

    public static void printZPattern(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // Print the first and last row
            if (i == 0 || i == rows - 1) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else { // Print the diagonal line
                System.out.print(matrix[i][cols - i - 1] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printZPattern(matrix);
    }
}

/*
Asymptotic analysis:

Let N be the number of rows (or columns) in the matrix.
The algorithm iterates through each element in the matrix once.
The time complexity is O(N^2) since each element is processed once.
The space complexity is O(1) as the algorithm uses a constant amount of extra space.
 */