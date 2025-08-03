package _44_Wildcard_Matching;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/wildcard-matching/description/
public class Solution {

    Map<String, Boolean> memRec = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int s_index, int p_index) {
        if (p_index == p.length() && s_index == s.length()) {
            return true; // Both strings are fully matched
        }

        if (p_index < p.length() && p.charAt(p_index) == '*') {
            return (s_index < s.length() && isMatch(s, p, s_index + 1, p_index))
                    || (isMatch(s, p, s_index, p_index + 1));
        }
        if (p_index < p.length()) {
            if (p.charAt(p_index) == '?') {
                return s_index < s.length() && isMatch(s, p, s_index + 1, p_index + 1);
            } else {
                return s_index < s.length() && s.charAt(s_index) == p.charAt(p_index) && isMatch(s, p, s_index + 1, p_index + 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "*"));
        System.out.println(s.isMatch("acdcb", "a*c?b"));
    }
}