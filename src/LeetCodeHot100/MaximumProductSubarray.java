package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    /**
     * 求最大值，可以看成求被0拆分的各个子数组的最大值。
     * 当一个数组中没有0存在，则分为两种情况：
     * 1.负数为偶数个，则整个数组的各个值相乘为最大值；
     * 2.负数为奇数个，则从左边开始，乘到最后一个负数停止有一个“最大值”，从右边也有一个“最大值”，比较，得出最大值。
     */
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int a = 1;

        for (int num : nums) {
            if (num == 0){
                a = 1;
            }else {
                a = a * num;
            }
            ans = Math.max(ans,a);
        }

        a = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0){
                a = 1;
            }else {
                a = a * nums[i];
            }
            ans = Math.max(ans,a);
        }

        return ans;
    }
}
