package _746_Min_Cost_Climbing_Stairs;

// https://leetcode.com/problems/min-cost-climbing-stairs
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0;
        int second = 0;
        int current = cost[0];

        for (int i = 2; i <= cost.length; i++) {
            current = Math.min(first + cost[i-2], second + cost[i-1]);
            first = second;
            second = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
