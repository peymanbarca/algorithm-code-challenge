
/*

Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] < A[j] and i < j.

Input:
N = 9
A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output:
6
Explanation:
In the given array A[1] < A[7]
satisfying the required
condition(A[i] < A[j]) thus giving
the maximum difference of j - i
which is 6(7-1).

 */

public class Maximum_Index {
    public static int findMaxIndexDifference(int[] A) {
        int n = A.length;

        // Create two arrays to store the minimum values to the left and maximum values to the right of each element.
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMin array
        leftMin[0] = A[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], A[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i]);
        }

        int maxIndexDiff = 0;
        int i = 0, j = 0;

        // Traverse both arrays and find the maximum j - i while satisfying the constraint A[i] < A[j]
        while (i < n && j < n) {
            if (leftMin[i] < rightMax[j]) {
                maxIndexDiff = Math.max(maxIndexDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxIndexDiff;
    }

    public static void main(String[] args) {
        int[] A = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int maxIndexDiff = findMaxIndexDifference(A);

        System.out.println("Maximum j - i: " + maxIndexDiff);
    }
}


/*

Asymptotic Analysis:

Time Complexity:

The algorithm fills the leftMin and rightMax arrays in linear time, which is O(N).
Then, it uses two pointers (i and j) to find the maximum j - i while satisfying the constraint in linear time, which is also O(N).
Therefore, the overall time complexity is O(N), where N is the number of elements in the array.
Space Complexity:

The algorithm uses two additional arrays leftMin and rightMax, each of size N, to store the minimum values to the left and maximum values to the right of each element.
The space complexity is O(N) for these arrays.

 */