
/*
Given a matrix of size N x N. Print the elements of the matrix in the spiral like pattern
 */

public class Print_a_given_matrix_in_spiral_form {

    public static void printSpiralPattern(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Print top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            // Print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Print bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            // Print left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
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

        printSpiralPattern(matrix);
    }
}

/*
Asymptotic analysis:

Let N be the number of rows (or columns) in the matrix.
The algorithm iterates through each element in the matrix once.
The time complexity is O(N^2) since each element is processed once.
The space complexity is O(1) as the algorithm uses a constant amount of extra space.
 */