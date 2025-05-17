package _3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.getOrDefault(c, -1) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
            System.out.println("left: " + (left-1) + ", right: " + right + ", max: " + max + ", sub string: " + s.substring(left, right + 1));
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstringOld(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            int length;
            boolean isContain = false;
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                length = right - map.get(s.charAt(right));
                left = map.get(s.charAt(right)) + 1;
                isContain = true;
            } else {
                length = right - left + 1;
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, length);

            int leftBefore = isContain ? left - 1 : left;
            System.out.println("left: " + leftBefore + ", right: " + right + ", max: " + max + ", sub string: " + s.substring(left, right + 1));
            right++;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabccbc"));
        System.out.println();
        System.out.println();
        System.out.println(solution.lengthOfLongestSubstringOld("abcabccbc"));
    }
}
