package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 除自身以外数组的乘积
 */
public class ProductArrayExceptSelf {

    /**
     * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
     * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
     * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
     *
     * 从左到右乘一遍 dpLeft[i] = nums[0]*nums[1]* ... *nums[i-1]
     * 从右往左乘一遍 dpRight[i] = nums[length - 1]*nums[length - 2]*...*nums[length - i]
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] dpLeft = new int[nums.length];
        int[] dpRight = new int[nums.length];
        int[] dp = new int[nums.length];
        dpLeft[0] = 1;
        dpRight[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            dpLeft[i] = dpLeft[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            dpRight[i] = dpRight[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i] = dpLeft[i] * dpRight[i];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
