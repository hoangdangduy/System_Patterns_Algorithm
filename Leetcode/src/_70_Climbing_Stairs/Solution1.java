package _70_Climbing_Stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairs(n, memo);
    }

    public int climbStairs(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int sum = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        memo.put(n, sum);
        return sum;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.climbStairs(4));
    }
}