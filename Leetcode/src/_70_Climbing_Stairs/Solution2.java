package _70_Climbing_Stairs;

public class Solution2 {

    public int climbStairs(int n) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        if (n <= 2) {
            return n;
        }

        int result = 0;
        int first = 1;
        int second = 2;
        for (int i = 3; i <=n ; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.climbStairs(4));
    }
}