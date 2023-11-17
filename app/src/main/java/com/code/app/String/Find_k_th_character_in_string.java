
/*

Given a decimal number m. Convert it into a binary string and apply n iterations,
in each iteration 0 becomes 01, and 1 becomes 10. Find the kth (1-indexing) character in the string after the nth iteration.

 */

public class Find_k_th_character_in_string {
    public static char findKthCharacter(int m, int n, int k) {
        String binaryString = Integer.toBinaryString(m);

        for (int i = 0; i < n; i++) {
            binaryString = transform(binaryString);
        }

        return binaryString.charAt(k - 1); // 1-indexing
    }

    private static String transform(String binaryString) {
        StringBuilder result = new StringBuilder();

        for (char c : binaryString.toCharArray()) {
            if (c == '0') {
                result.append("01");
            } else {
                result.append("10");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 3;
        int k = 5;

        char result = findKthCharacter(m, n, k);

        System.out.println("The " + k + "th character after " + n + " iterations is: " + result);
    }
}


/*


Asymptotic analysis:

Let m be the decimal number, n be the number of iterations, and k be the index of the character to find.
The algorithm first converts the decimal number to a binary string, which takes O(log m) time.
It then performs n iterations, each of which doubles the length of the string.
The total time complexity is O(n * log m), where n is the number of iterations, and log m is the length of the binary representation of the decimal number.
The space complexity is O(log m) for the binary string.

 */