package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * 比特位计数
 */
public class CountingBits {

    /**
     * 找规律
     * 分奇数和偶数：
     * 偶数的二进制1个数超级简单，
     * 因为偶数是相当于被某个更小的数乘2，乘2怎么来的？
     * 在二进制运算中，就是左移一位，也就是在低位多加1个0，那样就说明dp[i] = dp[i / 2]
     * 奇数稍微难想到一点，奇数由不大于该数的偶数+1得到，偶数+1在二进制位上会发生什么？
     * 会在低位多加1个1，那样就说明dp[i] = dp[i-1] + 1，当然也可以写成dp[i] = dp[i / 2] + 1
     */
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
