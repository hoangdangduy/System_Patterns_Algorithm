package _6_Zigzag_Conversion;

import java.util.*;

// https://leetcode.com/problems/zigzag-conversion
public class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, LinkedList<Integer>> mapRows = new HashMap<>();

        mapRows.put(0, initFirstRow(numRows, s));
        Set<Integer> setTraversed = new HashSet<>(mapRows.get(0));

        for (int i = 1; i < numRows; i++) {
            LinkedList<Integer> link = new LinkedList<>();
            mapRows.get(i-1).forEach(integer -> {
                int indexProcessing = integer - 1;
                // process left
                if ((indexProcessing) > 0 && !setTraversed.contains(indexProcessing)) {
                    link.addLast(indexProcessing);
                    setTraversed.add(indexProcessing);
                }
                // process left
                indexProcessing = integer + 1;
                if ((indexProcessing) > 0 && !setTraversed.contains(indexProcessing)) {
                    link.addLast(indexProcessing);
                    setTraversed.add(indexProcessing);
                }
            });
            mapRows.put(i, link);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            mapRows.get(i).forEach(integer -> {
                if (integer < s.length()) {
                    sb.append(s.charAt(integer));
                }
            });
        }
        return sb.toString();
    }

    private LinkedList<Integer> initFirstRow(int numRows, String s) {
        int jump = 2 * numRows - 2;
        int i = 0;

        LinkedList<Integer> link = new LinkedList<>();
        if (numRows == 1) {
            for (int k = 0; k < s.length(); k++) {
                link.addLast(k);
            }
            return link;
        }

        while (i <= Math.max(s.length(), (s.length() / jump + 1) * jump)) {
            link.addLast(i);
            i += jump;

        }
        return link;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
        System.out.println(solution.convert("A", 1));
        System.out.println(solution.convert("AB", 1));
        System.out.println(solution.convert("ABCD", 3));
        System.out.println(solution.convert("ABCDE", 4));
    }
}
