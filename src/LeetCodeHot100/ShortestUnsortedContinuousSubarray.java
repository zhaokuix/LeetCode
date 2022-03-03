package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 最短无序连续子数组
 */
public class ShortestUnsortedContinuousSubarray {

    /**
     * 左右指针法
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums.length < 2){
            return 0;
        }
        //左边的比右边的大，需要全部排序
        if (nums[left] > nums[right]){
            return nums.length;
        }
        //完全相同时特殊处理
        if (nums[left] == nums[right]){
            boolean flag = true;
            for (int num : nums) {
                if (num != nums[left]) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                return 0;
            }
        }

        while (left < right){
            //计算（left，right）之间的最大和最小值
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                min = Math.min(min,nums[i]);
                max = Math.max(max,nums[i]);
            }
            if (min != Integer.MAX_VALUE && min >= nums[left]){
                left++;
            }else if (max != Integer.MIN_VALUE && max <= nums[right]){
                right--;
            }else if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE && nums[left] <= nums[right]){
                return 0;
            }else {
                return right - left + 1;
            }
        }
        return 0;
    }

    /**
     * 排序法
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray1(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int i = 0,j = nums.length - 1;
        while (i <= j && nums[i] == clone[i]) {
            i++;
        }
        while (i <= j && nums[j] == clone[j]) {
            j--;
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(findUnsortedSubarray1(nums));
    }
}
