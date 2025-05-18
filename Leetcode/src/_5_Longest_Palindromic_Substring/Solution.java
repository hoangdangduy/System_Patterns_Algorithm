package _5_Longest_Palindromic_Substring;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// O(n^2) time complexity
public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = longestPalindrome(s, i, i, result);
            result = longestPalindrome(s, i, i+1, result);
        }
        return result;
    }

    private static String longestPalindrome(String s, int left, int right, String result) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;
        if ((right - left + 1) > result.length()) {
            result = s.substring(left, right + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babab"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
    }
}
