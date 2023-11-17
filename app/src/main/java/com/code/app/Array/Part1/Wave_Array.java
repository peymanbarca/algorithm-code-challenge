
/*
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
 */

public class Wave_Array {
    public static void sortInWave(int[] arr) {
        int n = arr.length;

        // Traverse the array and swap adjacent elements
        for (int i = 0; i < n - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 7, 8};
        sortInWave(arr);

        System.out.print("Wave Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}



/*

Asymptotic Analysis:

Time Complexity:

The algorithm iterates through the array once and swaps adjacent elements if necessary.
Since each element is visited once, the time complexity is O(N), where N is the number of elements in the array.
Space Complexity:

The algorithm uses only a constant amount of extra space for swapping elements.
The space complexity is O(1).

 */