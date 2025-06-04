package _10_Regular_Expression_Matching;

import java.util.Objects;

// https://leetcode.com/problems/regular-expression-matching/
public class Solution {
    public boolean isMatch(String s, String p) {
        int firstStar = p.indexOf("*");

        for (int i = 0; i < firstStar - 1; i++) {
            if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
                return false;
            }
        }

        if (firstStar == -1) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < p.length()) {
                switch (p.charAt(j)) {
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
                }
            }
            return i == s.length() && j == p.length();
        } else {
            int i = firstStar;
            char charBeforeStar = p.charAt(i-1) == '.' ? s.charAt(i) : p.charAt(i-1);
            if (!Objects.equals(s.substring(0, firstStar-1), p.substring(0, firstStar - 1))) {
                return false;
            }
            do {
                var sNew = s.substring(i-1);
                var pNew = p.substring(firstStar + 1);
                var result = isMatch(sNew, pNew);
                if (result) {
                    return true;
                }
            } while (i <= s.length() && s.charAt(i++) == charBeforeStar);
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("aa", "a")); // false
        System.out.println(new Solution().isMatch("aa", "a*")); // true
//        System.out.println(new Solution().isMatch("ab", ".*")); // true
//        System.out.println(new Solution().isMatch("aab", "c*a*b")); // true
//        System.out.println(new Solution().isMatch("ab", ".*c")); // false
//        System.out.println(new Solution().isMatch("ab", ".*c")); // false
//        System.out.println(new Solution().isMatch("aaa", "a*a")); // true
//        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*.")); // false
//        System.out.println(new Solution().isMatch("ippi", "p*.")); // false
    }
}
