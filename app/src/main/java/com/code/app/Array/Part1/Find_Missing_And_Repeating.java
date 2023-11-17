
/*
Given an unsorted array Arr of size N of positive integers.
One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. Find these two numbers.

 */

public class Find_Missing_And_Repeating {
    public static int[] findMissingAndDuplicate(int[] Arr) {
        int[] result = new int[2];
        int n = Arr.length;

        int xorAll = 0;
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        int xorArr = Arr[0];
        for (int i = 1; i < n; i++) {
            xorArr ^= Arr[i];
        }

        for (int i = 0; i < n; i++) {
            xorArr ^= Arr[i];
            if (Arr[i] == xorArr) {
                result[0] = xorArr;
                result[1] = xorAll ^ xorArr;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] Arr = {4, 3, 2, 7, 8, 2, 6, 5};
        int[] missingAndDuplicate = findMissingAndDuplicate(Arr);

        System.out.println("Missing Number: " + missingAndDuplicate[1]);
        System.out.println("Duplicate Number: " + missingAndDuplicate[0]);
    }
}


/*

Asymptotic Analysis:

Time Complexity:

The algorithm iterates through the array three times: first for XORing all the numbers from 1 to N, second for XORing all the elements in the array, and third for finding the position where the XOR of the element and the array value is equal.
Each iteration takes O(N) time.
Therefore, the overall time complexity is O(N), where N is the number of elements in the array.
Space Complexity:

The algorithm uses a constant amount of extra space to store variables and the result array.
The space complexity is O(1).
This algorithm efficiently finds the missing and duplicate numbers in the array using the XOR operation and works in linear time complexity.

 */