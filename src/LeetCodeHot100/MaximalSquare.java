package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {

    /**
     * 动态规划
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     *
     * 设dp[i][j]是以（i,j）为右下角所能构成的正方形的边长
     * 到状态转移方程：
     * dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1;
     * 为什么是这个公式呢？想一下，如果以（i，j）为右下角的最大正方形的边长是4，
     * 那以（i-1,j）（i,j-1）（i-1,j-1）为右下角所能构成的正方形的最大边长肯定>=3
     *
     *
     *反过来：如果以（i-1,j）（i,j-1）（i-1,j-1）为右下角的构成的正方形的最大边长都是3
     * 分别用a、b、c覆盖以（i-1,j）（i,j-1）（i-1,j-1）为右下角的正方形
     * 0 a a a      0 a a a     c c c a
     * 0 a a a  =>  b b b a  => c c c a
     * 0 a a a      b b b a     c c c a
     * 0 0 0 0      b b b 0     b b b 0
     *
     * 由上覆盖图可知，此时只要matrix(i,j)是1，那么必定能形成一个边长为4的正方形。所以
     * 如果 matrix[i][j] == 1必然存在==>dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
     *
     */
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                }else if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j -1]) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        System.out.println((int)('0' - '0'));
    }
}
