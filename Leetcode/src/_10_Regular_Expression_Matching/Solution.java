package _10_Regular_Expression_Matching;

// https://leetcode.com/problems/regular-expression-matching/
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = p.length();

        while (i < n && j < m) {
            switch (p.charAt(j)) {
                case '.':
                    i++;
                    j++;
                    break;
                case '*':
                    char check;
                    if (p.charAt(j-1) == '.') {
                        check = s.charAt(i);
                    } else {
                        check = p.charAt(j-1);
                    }
                    while (i < n && s.charAt(i) == check) {
                        i++;
                    }
                    j++;
                    break;
                default:
                    if (s.charAt(i) == p.charAt(j)) {
                        i++;
                        j++;
                    } else {
                        i = 0;
                        j++;
                    }
            }
        }

        return i >= n;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("aa", "a")); // false
//        System.out.println(new Solution().isMatch("aa", "a*")); // true
//        System.out.println(new Solution().isMatch("ab", ".*")); // true
//        System.out.println(new Solution().isMatch("aab", "c*a*b")); // true
//        System.out.println(new Solution().isMatch("ab", ".*c")); // false
        System.out.println(new Solution().isMatch("ab", ".*c")); // false
    }
}
