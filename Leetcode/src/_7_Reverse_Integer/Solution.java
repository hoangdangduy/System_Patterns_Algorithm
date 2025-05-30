package _7_Reverse_Integer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/reverse-integer
public class Solution {
    public int reverse(int x) {
        int result  = 0;
        if (x == Integer.MIN_VALUE) {
            return 0; // Special case for Integer.MIN_VALUE, as it cannot be reversed
        }
        if (Math.abs(x) < 1_000_000_000) {
            while (x != 0) {
                result = result * 10 + x % 10;
                x /= 10;

                if (3 <= x && x <= 9 && result > 1_000_000_000) {
                    return 0;
                }
            }
            return result;
        } else {
            Queue<Integer> qX = buildQueue(x);
            Deque<Integer> qMax = buildQueue(x >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE);

            boolean numberBeforeLessThen = true;
            while (!qX.isEmpty()) {
                int xDigit = Math.abs(qX.poll());
                int maxDigit = Math.abs(qMax.pollLast());
                if (xDigit > maxDigit && numberBeforeLessThen) {
                    return 0;
                } else {
                    result = result * 10 + xDigit;
                    if (xDigit < maxDigit) {
                        numberBeforeLessThen = false;
                    }
                }
            }
            return x < 0 ? -result : result;
        }
    }

    private Deque<Integer> buildQueue(int x) {
        Deque<Integer> q = new LinkedList<>();
        while(x != 0) {
            q.add(x % 10);
            x /= 10;
        }
        return q;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(-2147483412)); // -2143847412
        System.out.println(new Solution().reverse(-2147483648)); // 0
    }
}
