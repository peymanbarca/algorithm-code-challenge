package com.code.app.Matrix;
/*
Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix(mat[][])
 the task to check if the current configuration is valid or not where a 0 represents an empty block.

Input: mat[][] = [
[3, 0, 6, 5, 0, 8, 4, 0, 0]
[5, 2, 0, 0, 0, 0, 0, 0, 0]
[0, 8, 7, 0, 0, 0, 0, 3, 1]
[0, 0, 3, 0, 1, 0, 0, 8, 0]
[9, 0, 0, 8, 6, 3, 0, 0, 5]
[0, 5, 0, 0, 9, 0, 6, 0, 0]
[1, 3, 0, 0, 0, 0, 2, 5, 0]
[0, 0, 0, 0, 0, 0, 0, 7, 4]
[0, 0, 5, 2, 0, 6, 3, 0, 0]
]
Output: 1
Explanation: It is possible to have a
proper sudoku.

 */
public class Is_Sudoku_Valid {
    public static boolean isValidSudoku(int[][] board) {
        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }

        // Check 3x3 subgrids
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubgrid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isValidRow(int[][] board, int row) {
        boolean[] seen = new boolean[10];

        for (int i = 0; i < 9; i++) {
            int num = board[row][i];
            if (num != 0) {
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        return true;
    }

    private static boolean isValidColumn(int[][] board, int col) {
        boolean[] seen = new boolean[10];

        for (int i = 0; i < 9; i++) {
            int num = board[i][col];
            if (num != 0) {
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        return true;
    }

    private static boolean isValidSubgrid(int[][] board, int startRow, int startCol) {
        boolean[] seen = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = board[startRow + i][startCol + j];
                if (num != 0) {
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        boolean result = isValidSudoku(sudokuBoard);

        if (result) {
            System.out.println("The Sudoku configuration is valid.");
        } else {
            System.out.println("The Sudoku configuration is not valid.");
        }
    }
}


/*

Asymptotic analysis:

The algorithm iterates through each row, column, and subgrid once.
The time complexity is O(1) since the size of the Sudoku board is constant (9x9).
The space complexity is O(1) as the algorithm uses a constant amount of extra space.
 */