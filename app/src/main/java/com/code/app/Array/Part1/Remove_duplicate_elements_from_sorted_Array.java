
/*

Given a sorted array A[] of size N, delete all the duplicated elements from A[].
Modify the array such that if there are X distinct elements in it then the first X positions
 of the array should be filled with them in increasing order and return the number of distinct elements in the array.

1. Don't use set or HashMap to solve the problem.
2. You must return the number of distinct elements(X) in the array,
 the driver code will print all the elements of the modified array from index 0 to X-1 as output of your code.

 */

public class Remove_duplicate_elements_from_sorted_Array {
    public static int removeDuplicates(int[] A) {
        int n = A.length;
        if (n == 0 || n == 1) {
            return n;
        }

        int x = 1; // Initialize distinct element count to 1

        // Iterate through the array from the second element
        for (int i = 1; i < n; i++) {
            // If the current element is different from the previous one
            if (A[i] != A[i - 1]) {
                A[x] = A[i]; // Move the distinct element to the next position
                x++; // Increment the distinct element count
            }
        }

        return x; // Return the number of distinct elements
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 2, 2, 3, 4, 4, 5, 5, 5, 5};

        int distinctCount = removeDuplicates(A);
        System.out.println("Number of distinct elements: " + distinctCount);

        // Print the modified array from index 0 to X-1
        for (int i = 0; i < distinctCount; i++) {
            System.out.print(A[i] + " ");
        }
    }
}


/*
The time complexity of the provided algorithm is O(N), where N is the size of the sorted array `A[]`.
 This is because it iterates through the array once, and for each element, it performs a constant number of operations (comparisons and assignments).

The auxiliary space complexity of the algorithm is O(1) because it uses a constant amount of extra space
 to keep track of the distinct elements and modify the input array in-place. It doesn't use any additional data structures
 that grow with the input size, so the space complexity is constant.
 */