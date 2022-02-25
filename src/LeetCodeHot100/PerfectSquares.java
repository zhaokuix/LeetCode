package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * 完全平方数
 */
public class PerfectSquares {
    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     *
     * 设dp[i]和为 i 的完全平方数的最少数量。
     * 初始化dp[i]为i。
     * 对于dp[k](n>k>i),dp
     * dp[k] = min(dp[k], dp[k - j*j] + 1)
     * 在数k之前一定存在着许多数j使得 j+一个完全平方数等于 k
     * 找一个dp[k]最小的数即可。
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= k; j++) {
                if (k - j*j >= 0){
                    dp[k] = Math.min(dp[k], dp[k - j*j] + 1);
                }
            }
        }
        return dp[n];
    }
}
