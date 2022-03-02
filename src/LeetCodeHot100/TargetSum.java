package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * 目标和
 */
public class TargetSum {

    static int count = 0;

    /**
     * 方法一：
     * dfs，计算每一条路径的和，求满足条件的次数
     */
    public static int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return count;
    }

    public static void dfs(int[] nums, int i, int target, int num) {
        //遍历完了
        if (i == nums.length) {
            if (num == target) {
                count++;
            }
            return;
        }
        dfs(nums, i + 1, target, num + nums[i]);
        dfs(nums, i + 1, target, num - nums[i]);
    }

    /**
     * 方法二：动态规划
     * 本本题可以转化为背包问题
     * 假设选择作为正数的和为pos，数据全部和为sum,那选择为负数的和为sum-pos
     * target = pos - (sum - pos)
     * pos = (sum + target) / 2
     * <p>
     * 令dp[i][j] 为在前i个数中，选出若干数能组成j的方案的个数，0<=j<=pos
     * 当不选i时，dp[i][j] = dp[i-1][j]
     * 当选i时，nums[i] 必须小于等于 j，dp[i][j] = 不选时的方案数 + dp[i-1][j-nums[i]]
     * 边界值：j = 0时，i不选，dp[0][0] = 1;
     */
    public static int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //奇数不满足条件直接返回
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int pos = (sum + target) / 2;
        if (pos < 0){
            return 0;
        }
        int[][] dp = new int[nums.length + 1][pos + 1];
        //初始化边界值
        dp[0][0] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < pos + 1; j++) {
                //当不选i时，dp[i][j] = dp[i-1][j]
                dp[i][j] = dp[i - 1][j];
                //当选i时，nums[i] 必须小于等于 j，dp[i][j] = dp[i-1][j-i]
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][pos];
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
//        TreeNode root = buildTree(nums, -1, 0);
        System.out.println(findTargetSumWays1(nums, 1));
    }
}
