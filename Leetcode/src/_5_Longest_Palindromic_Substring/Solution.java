package _5_Longest_Palindromic_Substring;

import java.util.Objects;

public class Solution {
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
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babab"));
//        System.out.println(solution.longestPalindrome("cbbd"));
//        System.out.println(solution.longestPalindrome("bb"));
    }
}
