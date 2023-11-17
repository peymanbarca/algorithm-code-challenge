
/*
Given an array of positive integers. Find the length of the longest sub-sequence
such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

 */

import java.util.HashSet;

public class Longest_Consecutive_subsequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxSequenceLength = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequenceLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequenceLength++;
                }

                maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
            }
        }

        return maxSequenceLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestSequenceLength = longestConsecutive(nums);

        System.out.println("Length of the longest subsequence: " + longestSequenceLength);
    }
}


/*

Asymptotic Analysis:

Time Complexity:

The algorithm iterates through the array once to populate the HashSet, which takes O(N) time.
It then iterates through the array again, but this time it only visits the start of each consecutive sequence, and for each sequence, it iterates as long as consecutive elements exist.
In the worst case, it iterates through each element only once, so the time complexity is O(N).
Space Complexity:

The algorithm uses a HashSet to store the elements, which can take up to O(N) additional space for the worst case.
The space complexity is O(N).

 */