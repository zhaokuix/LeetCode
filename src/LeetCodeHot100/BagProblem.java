package LeetCodeHot100;

/**
 * 背包问题
 * 给定 3 件物品，物品的重量为 weight[]={1,3,1}，
 * 对应的价值为 value[]={15,30,20}。现挑选物品放入背包中，
 * 假定背包能承受的最大重量 W 为 4，
 * 问应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 */
public class BagProblem {

    /**
     * 令dp[i][j] 为在前i件物品中，放入容量为j的背包中所获得的最大值
     * 对于dp[i][j] i不选时，dp[i][j] = dp[i-1][j]
     * i选时，dp[i][j] = value[i] + dp[i-1][j-weight[i]]
     * 在选和不选中取最大值就是dp[i][j]的值
     * 边界值：
     * j为0时，dp[i][j] = 0;
     * i为0时，dp[i][j] = 0
     */
    public static int maxValue(int[] weight, int[] value, int w) {
        int n = weight.length;
        if (n == 0){
            return 0;
        }
        //n = 0时表示一个物品也不选
        int[][] dp = new int[n + 1][w + 1];
        /*
        int数组默认为0，可以不初始化边界值
        */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - weight[i - 1] >= 0) {
                    //选择第i号物品时，前提是能放得下
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    //不选第i号物品时
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }


    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] v = {15, 30, 20};
        int W = 4;
        System.out.println(maxValue(w, v, W));
    }
}
