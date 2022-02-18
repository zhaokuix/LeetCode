package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeBuySellStock {
    /**
     * 第i天能获得的最大利润为：当前价格减去前i天内最低的价格
     * 可以用动态规划来解决
     * dp[i]表示前i天最低的价格
     * dp[i] = Max(dp[i-1],prices[i])
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0){
                dp[i] = prices[0];
            }else {
                dp[i] = Math.min(dp[i - 1], prices[i]);
            }
            ans = Math.max(ans,prices[i] - dp[i]);
        }
        return ans;
    }
}
