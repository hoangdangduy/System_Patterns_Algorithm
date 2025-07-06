package _44_Wildcard_Matching;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/wildcard-matching/description/
public class Solution {

    public boolean isMatch(String s, String p) {
        // key 1: index in p
        // key 2: index in s
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();
//        int j = 0;
//        while (j <= p.length()) {
//            var result = isMatch(s, p, map, 0, j);
//            if (result) {
//                return true;
//            }
//            j++;
//        }
//        return false;
        return isMatch(s, p, map, 0, 0);
    }

    public boolean isMatch(String s, String p, Map<Integer, Map<Integer, Boolean>> map, int i, int j) {
        if (j == p.length() && i == s.length()) {
            return true;
        }

        if (j == p.length() && i < s.length()
            || j < p.length() && i > s.length()) {
            return false;
        }

        if (p.charAt(j) == '*') {
            for (int sIndex = i; sIndex < s.length(); sIndex++) {
                if (!Objects.equals(getValue(map, j, sIndex), Boolean.FALSE)) {
                    var result = isMatch(s, p, map, sIndex, j+1);
                    if (result) {
                        return true;
                    } else {
                        extracted(map, j+1, sIndex);
                    }
                }
            }
        } else if (p.charAt(j) == '?') {
            var result = isMatch(s, p, map, i + 1, j + 1);
            if (result) {
                return true;
            } else {
                extracted(map, j + 1, i + 1);
            }
        } else {
            if (p.charAt(j) != s.charAt(i)) {
                extracted(map, j, i);
            } else {
                var result = isMatch(s, p, map, i + 1, j + 1);
                if (result) {
                    return true;
                } else {
                    extracted(map, j + 1, i + 1);
                }
            }
        }
        return false;
    }

    private static void extracted(Map<Integer, Map<Integer, Boolean>> map, int j, int sIndex) {
        map.computeIfPresent(j, (k, v) -> {
            v.put(k, false);
            return v;
        });
        map.computeIfAbsent(j, k -> new HashMap<>()).put(sIndex, false);
    }

    private Boolean getValue(Map<Integer, Map<Integer, Boolean>> map, int key1, int key2) {
        if (!map.containsKey(key1)) {
            return null;
        }

        Map<Integer, Boolean> innerMap = map.get(key1);
        if (!innerMap.containsKey(key2)) {
            return null;
        }

        return innerMap.get(key2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa", "*"));
    }
}
