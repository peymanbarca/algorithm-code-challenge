
/*

Given an array A of N elements. Find the majority element in the array.
 A majority element in an array A of size N is an element that appears strictly more than N/2 times in the array.

 */


public class Majority_Element {

    public static int findMajorityElement(int[] A) {
        int candidate = 0;
        int count = 0;

        for (int num : A) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // At this point, candidate is a potential majority element
        // Verify if it is indeed the majority element
        count = 0;
        for (int num : A) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > A.length / 2) {
            return candidate; // It is the majority element
        } else {
            return -1; // No majority element found
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 2, 3, 2, 4, 2, 2};
        int majorityElement = findMajorityElement(A);
        if (majorityElement != -1) {
            System.out.println("Majority Element: " + majorityElement);
        } else {
            System.out.println("No majority element found.");
        }
    }
}




/*

Time Complexity:

The algorithm consists of two passes through the array:
The first pass determines a candidate for the majority element in O(N) time.
The second pass verifies if the candidate is indeed the majority element in O(N) time.
Therefore, the overall time complexity is O(N).
Space Complexity:

The algorithm uses only a constant amount of extra space to store the candidate and count variables.
The space complexity is O(1).
The Boyer-Moore Voting Algorithm is an efficient and elegant way to find the majority element in an array with a linear time complexity.

 */