package _509_Fibonacci_Number;

// https://leetcode.com/problems/fibonacci-number/description/
public class Solution {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int result = 0;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(3));
    }
}
