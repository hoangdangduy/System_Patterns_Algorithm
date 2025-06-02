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
                case '*':
                    if (s.charAt(i) == p.charAt(j)) {
                        j++;
                    }
                    i++;
                    break;
                case '.':
                    i++;
                    j++;
                    break;
                default:
                    if (s.charAt(i) != p.charAt(j)) {
                        return false;
                    }
                    i++;
                    j++;
                    break;
            }
        }

        if (p.charAt(j-1) != '*' && p.charAt(j-1) != '.' && p.charAt(j-1) != s.charAt(i)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a")); // false
        System.out.println(new Solution().isMatch("aa", "a*")); // true
        System.out.println(new Solution().isMatch("ab", ".*")); // true
    }
}
