package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     *
     * 方法一：暴力循环,超时了
     * @param nums 数组
     * @return 最大和
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int t0 = 0;
            for (int j = i; j < nums.length; j++) {
                t0 = nums[j] + t0;
                t = Math.max(t, t0);
            }
            ans = Math.max(ans,t);
        }
        return ans;
    }

    /**
     * 类似于加油站问题，如果连续几个数字之和小于0，可以直接舍弃那些数，
     * 因为那些数可以等效看成是一个数
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
