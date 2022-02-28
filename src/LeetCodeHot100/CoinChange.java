package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 零钱兑换
 */
public class CoinChange {

    /**
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        //初始化dp
        Arrays.fill(dp,1,dp.length,amount + 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
