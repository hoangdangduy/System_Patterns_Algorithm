package _9_Palindrome_Number;

// https://leetcode.com/problems/palindrome-number/
public class Solution {
    public boolean isPalindrome(int x) {
        String palindrome = String.valueOf(x);
        int left;
        int right;
        if (palindrome.length() % 2 == 0) {
            left = palindrome.length() / 2 - 1;
            right = palindrome.length() / 2;
        } else {
            left = palindrome.length() / 2 - 1;
            right = palindrome.length() / 2 + 1;
        }

        while (left >= 0) {
            if (palindrome.charAt(left) != palindrome.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121)); // true
        System.out.println(new Solution().isPalindrome(-121)); // false
        System.out.println(new Solution().isPalindrome(10)); // false
    }
}
