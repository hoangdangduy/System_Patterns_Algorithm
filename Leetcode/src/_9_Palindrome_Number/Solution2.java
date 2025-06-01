package _9_Palindrome_Number;

// https://leetcode.com/problems/palindrome-number/
public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return x == result || x == result / 10;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution2().isPalindrome(121)); // true
//        System.out.println(new Solution2().isPalindrome(-121)); // false
//        System.out.println(new Solution2().isPalindrome(10)); // false
        System.out.println(new Solution2().isPalindrome(20)); // false
    }
}
