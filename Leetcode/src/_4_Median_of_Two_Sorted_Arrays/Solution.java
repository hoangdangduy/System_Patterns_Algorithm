package _4_Median_of_Two_Sorted_Arrays;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums1, nums2, 0, nums1.length);
        } else {
            return findMedianSortedArrays(nums2, nums1, 0, nums2.length);
        }
    }

    public double findMedianSortedArrays(int[] s1, int[] s2, int low, int high) {
        int partition1 = (low + high)/2;
        int partition2 = (s1.length + s2.length + 1)/2 - partition1;

        int maxLeft1 = partition1 == 0 ? maxLeft1 = Integer.MIN_VALUE : s1[partition1-1];
        int minRight1 = partition1 < s1.length ? s1[partition1] : Integer.MAX_VALUE;
        int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : s2[partition2-1];
        int minRight2 = partition2 < s2.length ? s2[partition2] : Integer.MAX_VALUE;

        if (maxLeft1 > minRight2) {
            high = partition1 - 1;
            return findMedianSortedArrays(s1, s2, low, high);
        } else if (maxLeft2 > minRight1) {
            low = partition1 + 1;
            return findMedianSortedArrays(s1, s2, low, high);
        } else {
            if ((s1.length + s2.length) % 2 != 0) {
                return Math.max(maxLeft1, maxLeft2);
            } else {
                return (double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4)); // 2.5

        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        System.out.println(solution.findMedianSortedArrays(nums5, nums6)); // 0.0
    }
}
