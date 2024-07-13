import java.util.*;

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        hashTable.put(0, 0);
        hashTable.put(1, 0);
        return minCost(cost, cost.length, hashTable);
    }

    public int minCost(int[] cost_list, int nth, Hashtable hashTable) {
        int cost_val;
        if (hashTable.containsKey(nth)) {
            return (int) hashTable.get(nth);

        } else {
            int one_minus = minCost(cost_list, nth - 1, hashTable) + cost_list[nth - 1];
            int two_minus = minCost(cost_list, nth - 2, hashTable) + cost_list[nth - 2];

            cost_val = one_minus <= two_minus ? one_minus : two_minus;
            hashTable.put(nth, cost_val);

            return (int) hashTable.get(nth);
        }

    }
}