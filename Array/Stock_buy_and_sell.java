
/*
The cost of stock on each day is given in an array A[] of size N.
Find all the segments of days on which you buy and sell the stock so that in between those days for which profit can be generated.

The task is to complete the function stockBuySell() which takes an array of A[] and N as
input parameters and finds the days of buying and selling stock.
The function must return a 2D list of integers containing all the buy-sell pairs i.e.
 the first value of the pair will represent the day on which you buy the stock and
 the second value represent the day on which you sell that stock. If there is No Profit, return an empty list.

 */

import java.util.ArrayList;
import java.util.List;

public class Stock_buy_and_sell {
    public static List<List<Integer>> stockBuySell(int[] A, int N) {
        List<List<Integer>> result = new ArrayList<>();
        int buyDay = 0;

        for (int sellDay = 1; sellDay < N; sellDay++) {
            if (A[sellDay] > A[sellDay - 1]) {
                continue; // Continue to the next day if the price is increasing
            } else {
                if (sellDay - buyDay > 1) {
                    // Only add a buy-sell pair if there is a profit
                    List<Integer> pair = new ArrayList<>();
                    pair.add(buyDay);
                    pair.add(sellDay - 1);
                    result.add(pair);
                }
                buyDay = sellDay;
            }
        }

        // Add the last buy-sell pair if there is a profit
        if (N - 1 - buyDay > 0) {
            List<Integer> pair = new ArrayList<>();
            pair.add(buyDay);
            pair.add(N - 1);
            result.add(pair);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {100, 180, 260, 310, 40, 535, 695};
        int N = A.length;

        List<List<Integer>> buySellPairs = stockBuySell(A, N);

        for (List<Integer> pair : buySellPairs) {
            System.out.println("Buy on day " + pair.get(0) + " and sell on day " + pair.get(1));
        }
    }
}


/*

Asymptotic Analysis:

Time Complexity:

The algorithm iterates through the array once, comparing adjacent elements and identifying buying and selling opportunities.
The time complexity of the algorithm is O(N), where N is the number of elements in the array.
Space Complexity:

The algorithm uses a list of lists to store the buy-sell pairs. The number of pairs is at most N/2 in the worst case.
The space complexity is O(N) for the output list.

 */