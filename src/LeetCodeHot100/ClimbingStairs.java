package LeetCodeHot100;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 满足斐波那契数列 1 1 2 3 5 8 13 21
 */
public class ClimbingStairs {

    /**
     *动态规划
     * dp[n] = dp[n-1] + dp[n-2]
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
