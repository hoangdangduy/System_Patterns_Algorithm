package _44_Wildcard_Matching;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/wildcard-matching/description/
public class Solution {

    public boolean isMatch(String s, String p) {
        Map<String, Boolean> map = new HashMap<>();
        return isMatch(s, p, 0, 0, map);
    }

    private boolean isMatch(String s, String p, int i, int j, Map<String, Boolean> map) {
        if (j == p.length() && i == s.length()) {
            return true; // Both strings are fully matched
        }

        if (j < p.length() && i == s.length()) {
            return false;
        }

        if (p.charAt(j) == '*') {
            for (int sIndex = i; sIndex < s.length(); sIndex++) {
                if (!map.containsKey((j+1) + "_" + sIndex)) {
                    var result = isMatch(s, p, sIndex, (j + 1), map);
                    if (result) {
                        return true;
                    }
                    map.put((j + 1) + "_" + sIndex, false);
                } else {
                    return map.get((j + 1) + "_" + sIndex);
                }
            }
        } else if (p.charAt(j) == '?') {
            if (!map.containsKey((j+1) + "_" + (i+1))) {
                var result = isMatch(s, p, i + 1, j + 1, map);
                if (result) {
                    return true;
                }
                map.put((j + 1) + "_" + (i + 1), false);
            } else {
                return map.get((j + 1) + "_" + (i + 1));
            }
        } else {
            if (s.charAt(i) == p.charAt(j)) {
                if (!map.containsKey((j + 1) + "_" + (i + 1))) {
                    var result = isMatch(s, p, i + 1, j + 1, map);
                    if (result) {
                        return true;
                    }
                    map.put((j + 1) + "_" + (i + 1), false);
                } else {
                    return map.get((j + 1) + "_" + (i + 1));
                }
            } else {
                map.put(j + "_" + i, false);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa", "a"));
    }
}
