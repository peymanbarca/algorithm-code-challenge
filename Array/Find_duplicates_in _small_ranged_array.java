
/*
Given an array a of size N which contains elements from 0 to N-1,
 you need to find all the elements occurring more than once in the given array.
  Return the answer in ascending order. If no such element is found, return list containing [-1].

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Find_duplicates_in _small_ranged_array {
    public static List<Integer> findDuplicateElements(int[] a) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : a) {
            if (!seen.add(num)) {
                if (duplicates.add(num)) {
                    result.add(num);
                }
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        }

        result.sort(null);
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 7, 8, 2, 6, 5, 4};
        List<Integer> duplicateElements = findDuplicateElements(a);

        System.out.println("Duplicate Elements: " + duplicateElements);
    }
}



/*

Asymptotic Analysis:

Time Complexity:

The algorithm iterates through the array once, and for each element, it checks whether it has been seen before or not using a HashSet. This operation takes constant time.
Therefore, the overall time complexity is O(N), where N is the number of elements in the array.
Space Complexity:

The algorithm uses two HashSet data structures, seen and duplicates, to keep track of elements that have been seen and elements that are duplicates.
The space complexity is O(N) for these sets because in the worst case, all elements in the array could be unique.

 */