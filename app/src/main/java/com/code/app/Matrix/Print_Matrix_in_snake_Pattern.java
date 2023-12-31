
/*

Given a matrix of size N x N. Print the elements of the matrix in the snake like pattern
 */

public class Print_Matrix_in_snake_Pattern {
    public static void printSnakePattern(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // Left to right for even rows
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                // Right to left for odd rows
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
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

        printSnakePattern(matrix);
    }
}

/*
Asymptotic analysis:

Let N be the number of rows (or columns) in the matrix.
The algorithm iterates through each element in the matrix once.
The time complexity is O(N^2) since each element is processed once.
The space complexity is O(1) as the algorithm uses a constant amount of extra space.
 */