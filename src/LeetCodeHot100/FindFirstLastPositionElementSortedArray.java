package LeetCodeHot100;

import java.util.Arrays;

/**
 *https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstLastPositionElementSortedArray {

    /**
     *
     * 在排序数组中查找元素的第一个和最后一个位置要求时间复杂度log(n) 两次二分查找
     * 查找第一个大于target的元素，下标减一就是元素的最后一个位置
     * 然后查找第一个小于target的元素，下标加一就是元素的第一个位置
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int minIndex = binarySearchMinIndex(nums,target);
        int maxIndex = binarySearchMaxIndex(nums, target);
        //如果两个都找到了
        if (minIndex != -1 && maxIndex != -1 && minIndex + 1 < nums.length && maxIndex - 1 >=0 && nums[minIndex + 1] == target){
            return new int[]{minIndex + 1, maxIndex - 1};
        }
        //如果maxIndex没找到，minIndex找到了
        if (maxIndex == -1 && nums[nums.length - 1] == target && minIndex + 1 < nums.length){
            return new int[]{minIndex + 1, nums.length - 1};
        }
        //如果maxIndex找到了，minIndex没找到
        if (minIndex == -1 && nums[0] == target && maxIndex > 0){
            return new int[]{0, maxIndex - 1};
        }
        //如果两个index都没找到
        if (minIndex == -1 && maxIndex == -1 && nums[0] == target && nums[nums.length - 1] == target ){
            return new int[]{0, nums.length - 1};
        }
        return new int[]{-1, -1};

    }

    /**
     * 先查找第一个目标值所在位置
     * 再查找最后一个目标值所在位置
     * 判断一下返回结果是否是目标值
     */
    public static int[] searchRange1(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        //查找第一个目标值的位置
        int minIndex = binarySearchMinIndex1(nums,target);
        //查找最后一个目标值的位置
        int maxIndex = binarySearchMaxIndex1(nums, target);

        if (minIndex != -1 && maxIndex != -1 && nums[minIndex] == target && nums[maxIndex] == target){
            return new int[]{minIndex,maxIndex};
        }
        return new int[]{-1,-1};

    }

    /**
     *查找第一个大于target的元素
     */
    public static int binarySearchMaxIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] > target){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     *查找第一个小于target的元素
     */
    public static int binarySearchMinIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] < target){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     *查找第一个等于target的元素
     */
    public static int binarySearchMinIndex1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] >= target){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     *查找最后一个等于target的元素
     */
    public static int binarySearchMaxIndex1(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] <= target){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange1(nums,10)));
//        System.out.println(binarySearchMaxIndex1(nums,9));
    }
}
