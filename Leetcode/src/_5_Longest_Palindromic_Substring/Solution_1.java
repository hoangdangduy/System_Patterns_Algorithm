package _5_Longest_Palindromic_Substring;

import java.util.Objects;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// O(n^3) time complexity
public class Solution_1 {
    public String longestPalindrome(String s) {
        int n = s.length() - 1;
        while (n >= 1) {
            for (int i = 0; i + n < s.length(); i++) {
                String args = s.substring(i, i+n+1);
                if (!Objects.equals(checkPalindromic(args), "")) {
                    return args;
                }
            }
            n--;
        }
        return String.valueOf(s.charAt(0));
    }

    public String checkPalindromic(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return "";
            } else {
                left++;
                right--;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
    }
}
