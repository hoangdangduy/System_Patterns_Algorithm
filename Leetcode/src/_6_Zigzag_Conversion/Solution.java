package _6_Zigzag_Conversion;

// https://leetcode.com/problems/zigzag-conversion
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int jump = 0;
        int currentRow = 0;
        for (char c: s.toCharArray()) {
            sbs[currentRow].append(c);
            if (numRows == 1) {
                continue;
            }
            if (currentRow == 0) {
                jump = 1;
            }
            if (currentRow == numRows - 1) {
                jump = -1;
            }
            currentRow += jump;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: sbs) {
            result.append(sb);
        }
        return result.toString();
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
