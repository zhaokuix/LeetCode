package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长递增子序列
 */
public class LongestIncreasingSubsequence {

    /**
     * 在num[i] > num[j]时
     * dp[j]为[0,i]中最大的连续子序列
     * dp[i] = max(dp[i],dp[j] + 1)
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}
