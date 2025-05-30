package _8_String_To_Integer_atoi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/string-to-integer-atoi/description/
public class Solution {
    public int myAtoi(String s) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean negative = false;
        boolean specialCharacter = false; // -, +, and letters

        for (char c: s.toCharArray()) {
            if (c == '-' && queue.isEmpty() && !specialCharacter) {
                negative = true;
                specialCharacter = true;
            } else if (Character.isDigit(c)) {
                queue.add((c - '0') * (negative ? -1 : 1)); // check: Convert char to int
                specialCharacter = true;
            } else if (Character.isWhitespace(c) && !specialCharacter) {
                // do nothing
            } else if (c == '+' && !specialCharacter) {
                specialCharacter = true;
            } else {
                break;
            }
        }

        // standardize queue
        boolean isStandardized = false;
        while (!isStandardized && !queue.isEmpty()) {
            int head = queue.peekFirst();
            if (head == 0) {
                queue.pollFirst();
            } else {
                isStandardized = true;
            }
        }

        if (queue.size() > 10) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else if (queue.size() == 10) {
            boolean numberBeforeLessThen = true;
            int result = 0;
            // compare with Min value
            if (negative) {
                Deque<Integer> minQueue = buildQueue(Integer.MIN_VALUE);
                while (!queue.isEmpty()) {
                    int digit = Math.abs(queue.pollFirst());
                    int minDigit = Math.abs(minQueue.pollLast());
                    if (digit > minDigit && numberBeforeLessThen) {
                        return Integer.MIN_VALUE;
                    } else {
                        result = result * 10 + digit;
                        if (digit < minDigit) {
                            numberBeforeLessThen = false;
                        }
                    }
                }
                return Math.abs(result) * -1;
            } else { // compare with Max value
                Deque<Integer> maxQueue = buildQueue(Integer.MAX_VALUE);
                while (!queue.isEmpty()) {
                    int digit = queue.pollFirst();
                    int maxDigit = maxQueue.pollLast();
                    if (digit > maxDigit && numberBeforeLessThen) {
                        return Integer.MAX_VALUE;
                    } else {
                        result = result * 10 + digit;
                        if (digit < maxDigit) {
                            numberBeforeLessThen = false;
                        }
                    }
                }
                return Math.abs(result);
            }
        } else {
            int result = 0;
            while (!queue.isEmpty()) {
                result = result * 10 + queue.poll().intValue();
            }
            return negative ? Math.abs(result) * -1 : result;
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
//        System.out.println(new Solution().myAtoi("42")); // 42
//        System.out.println(new Solution().myAtoi("-042")); // -42
//        System.out.println(new Solution().myAtoi("1337c0d3")); // 1337
//        System.out.println(new Solution().myAtoi("0-1")); // 0
//        System.out.println(new Solution().myAtoi("words and 987")); // 0
//        System.out.println(new Solution().myAtoi("+-12")); // 0
//        System.out.println(new Solution().myAtoi("21474836460")); // 2147483647
//        System.out.println(new Solution().myAtoi("  0000000000012345678")); // 12345678
//        System.out.println(new Solution().myAtoi("   +0 123")); // 0
//        System.out.println(new Solution().myAtoi("2147483648")); // 2147483647
        System.out.println(new Solution().myAtoi("2147483646")); //
    }
}
