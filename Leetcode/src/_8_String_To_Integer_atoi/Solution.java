package _8_String_To_Integer_atoi;

// https://leetcode.com/problems/string-to-integer-atoi/description/
public class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int n = s.length();
        int i = 0;

        // Skip leading whitespace
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        if (i < n && !Character.isDigit(s.charAt(i))) {
            // Check for sigh
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().myAtoi("42")); // 42
//        System.out.println(new Solution().myAtoi("-042")); // -42
//        System.out.println(new Solution().myAtoi("1337c0d3")); // 1337
//        System.out.println(new Solution().myAtoi("0-1")); // 0
        System.out.println(new Solution().myAtoi("words and 987")); // 0
//        System.out.println(new Solution().myAtoi("+-12")); // 0
//        System.out.println(new Solution().myAtoi("21474836460")); // 2147483647
//        System.out.println(new Solution().myAtoi("  0000000000012345678")); // 12345678
//        System.out.println(new Solution().myAtoi("   +0 123")); // 0
//        System.out.println(new Solution().myAtoi("2147483648")); // 2147483647
//        System.out.println(new Solution().myAtoi("2147483646")); //
//        System.out.println(new Solution().myAtoi("   -042")); //
//        System.out.println(new Solution().myAtoi("+1")); //
//        System.out.println(new Solution().myAtoi(" ")); //
    }
}
