package _10_Regular_Expression_Matching;

import java.util.Objects;

// https://leetcode.com/problems/regular-expression-matching/
public class Solution {
    public boolean isMatch(String s, String p) {
            int firstStar = p.indexOf("*");

            if (s.length() == 0) {
                return false;
            }

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
                int i = firstStar-1;
                if (p.charAt(i) == '.') {
                    if (firstStar == p.length() - 1) {
                        return true;
                    }
                    char charAfterStar = p.charAt(firstStar + 1);
                    int j = 0;
                    while (j < s.length() && s.charAt(j) != charAfterStar) {
                        j++;
                    }
                    var sNew = s.substring(j);
                    var pNew = p.substring(firstStar + 1);
                    return isMatch(sNew, pNew);
                } else {
                    char charBeforeStar = p.charAt(i) == '.' ? s.charAt(i) : p.charAt(i);
                    if (!Objects.equals(s.substring(0, i), p.substring(0, i))) {
                        return false;
                    }
                    do {
                        var sNew = s.substring(i);
                        var pNew = p.substring(firstStar + 1);
                        var result = isMatch(sNew, pNew);
                        if (result) {
                            return true;
                        }
                    } while (i < s.length() && s.charAt(i++) == charBeforeStar);
                }

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
//        System.out.println(new Solution().isMatch("a", ".*..a*")); // false
    }
}
