package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 打家劫舍
 */
public class HouseRobber {

    /**
     * 动态规划
     * dp[i] = max(dp[i-2] + nums[i],dp[i - 1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
