
/*
Find out the maximum sub-array of non negative numbers from an array.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length.
If there is still a tie, then return the segment with minimum starting index.
If no such subarray is present return "-1"

 */

public class Maximum_Sub_Array {
    public static int[] findMaxNonNegativeSubArray(int[] A) {
        int start = 0;
        int end = -1;
        int maxStart = -1;
        int maxEnd = -1;
        long sum = 0;
        long maxSum = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                sum += A[i];
                end = i;
            } else {
                sum = 0;
                start = i + 1;
            }

            if (sum > maxSum || (sum == maxSum && (end - start > maxEnd - maxStart || (end - start == maxEnd - maxStart && start < maxStart)))) {
                maxSum = sum;
                maxStart = start;
                maxEnd = end;
            }
        }

        if (maxStart == -1) {
            return new int[]{-1}; // No non-negative subarray found
        } else {
            int[] result = new int[maxEnd - maxStart + 1];
            for (int i = maxStart; i <= maxEnd; i++) {
                result[i - maxStart] = A[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 5, -7, 2, 3};
        int[] maxSubArray = findMaxNonNegativeSubArray(A);

        if (maxSubArray[0] == -1) {
            System.out.println("No non-negative subarray found.");
        } else {
            System.out.print("Maximum Non-Negative Subarray: ");
            for (int num : maxSubArray) {
                System.out.print(num + " ");
            }
        }
    }
}


/*
Asymptotic Analysis:

Time Complexity:

The algorithm iterates through the array once, maintaining the current sub-array sum and finding the maximum sub-array.
Since each element is visited once, the time complexity is O(N), where N is the number of elements in the array.
Space Complexity:

The algorithm uses a constant amount of extra space to store variables.
The space complexity is O(1) apart from the space needed to store the result, which is O(maxEnd - maxStart).
 */