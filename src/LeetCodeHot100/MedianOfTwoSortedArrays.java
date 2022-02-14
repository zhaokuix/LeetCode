package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    /**
     * 合并后使用快速排序，快速排序时间复杂度O(n*log(n))
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int value : nums1) list.add(value);
        for (int value : nums2) list.add(value);
        Collections.sort(list);
        if (list.size() % 2 == 1) {
            return list.get(list.size() / 2);
        } else {
            return ((long) list.get(list.size() / 2) + (long) list.get(list.size() / 2 - 1)) / 2.0;
        }
    }

    /**
     * 双指针合并两个有序数组时间复杂度O(m+n)
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        //数组1的指针
        int i = 0;
        //数组2的指针
        int j = 0;
        int length = nums1.length + nums2.length;
        int[] mergeArray = new int[length];
        int cur = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length && nums1[i] <= nums2[j]) {
                mergeArray[cur++] = nums1[i++];
            } else if (i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) {
                mergeArray[cur++] = nums2[j++];
            } else if (i < nums1.length && j >= nums2.length) {
                mergeArray[cur++] = nums1[i++];
            } else if (i >= nums1.length && j < nums2.length) {
                mergeArray[cur++] = nums2[j++];
            }
        }
        if (length % 2 == 1) {
            return mergeArray[length / 2];
        } else {
            return ((long) mergeArray[length / 2] + (long) mergeArray[length / 2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
