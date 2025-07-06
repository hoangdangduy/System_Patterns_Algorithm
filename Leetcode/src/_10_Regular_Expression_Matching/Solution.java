package _10_Regular_Expression_Matching;

import java.util.Objects;

// https://leetcode.com/problems/regular-expression-matching/
public class Solution {

    public boolean isMatch(String s, String p) {
        Boolean[][] memoryMard = new Boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                memoryMard[i][j] = null;
            }
        }
        return isMatch(s, p, memoryMard);

    }

    private boolean isMatch(String s, String p, Boolean[][] memoryMard) {
        if (memoryMard[s.length()][p.length()] != null) {
            return memoryMard[s.length()][p.length()];
        }

        int firstStar = p.indexOf("*");

        if (firstStar == -1) {
            if (s.length() != p.length()) {
                return false;
            }

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
                    return false;
                }
            }
            return true;
        } else {
            int i = firstStar - 1;
            if (isNonMatchStart(s, p, firstStar - 1)) {
                return false;
            }
            String sChild;
            String pChild;
            if (Character.isAlphabetic(p.charAt(firstStar - 1))) {
                do {
                    sChild = s.substring(i);
                    pChild = p.substring(firstStar + 1);
                    boolean match = isMatch(sChild, pChild, memoryMard);
                    memoryMard[sChild.length()][pChild.length()] = match;
                    if (match) {
                        return true;
                    }
                } while (i < s.length() && s.charAt(i++) == p.charAt(firstStar - 1));
            } else if (p.charAt(firstStar - 1) == '.') {
                while (i <= s.length()) {
                    sChild = s.substring(i);
                    pChild = p.substring(firstStar + 1);
                    boolean match = isMatch(sChild, pChild, memoryMard);
                    memoryMard[sChild.length()][pChild.length()] = match;
                    if (match) {
                        return true;
                    }
                    i++;
                }
            }
        }
        return false;
    }

    private boolean isNonMatchStart(String s, String p, int endIndex) {
        if (endIndex > s.length()) {
            return true;
        }

        int i = 0;
        while (i < endIndex) {
            if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') {
                return true;
            }
            i++;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a")); // false
        System.out.println(new Solution().isMatch("aa", "a*")); // true
        System.out.println(new Solution().isMatch("ab", ".*")); // true
        System.out.println(new Solution().isMatch("aab", "c*a*b")); // true
        System.out.println(new Solution().isMatch("ab", ".*c")); // false
        System.out.println(new Solution().isMatch("ab", ".*c")); // false
        System.out.println(new Solution().isMatch("aaa", "a*a")); // true
        System.out.println(new Solution().isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(new Solution().isMatch("ippi", "p*.")); // false
        System.out.println(new Solution().isMatch("a", ".*..a*")); // false
        System.out.println(new Solution().isMatch("a", "ab*a")); // false
        System.out.println(new Solution().isMatch("ab", ".*..c*")); // true
    }
}
