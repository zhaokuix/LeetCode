package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    /**
     * 最小路径和
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 1,3,1
     * 1,5,1
     * 4,2,1
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 方法一：动态规划
     * dp[i,j] = min(dp[i-1,j] , dp[i,j-1]) + grid[i,j]
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化边界值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 方法二：记忆化dfs
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] array = new int[m-1][n-1];
        return dfs(grid,array,m,n);
    }
    public int dfs(int[][] grid,int[][] array, int m, int n){
        /**
         * 已经计算过了，直接取计算后的数据
         */
        if (array[m][n] != 0){
            return array[m][n];
        }
        //结束点
        if (m == 0 && n == 0){
            array[m][n] = grid[m][n];
            return array[m][n];
        }else if (m == 0 && n != 0 ){
            array[m][n] = grid[m][n] + dfs(grid,array,m,n-1);
            return array[m][n];
        }else if (m != 0 && n == 0){
            array[m][n] = grid[m][n] + dfs(grid,array,m-1,n);
            return array[m][n];
        }else {
            array[m][n] = grid[m][n] + Math.min(dfs(grid,array,m-1,n),dfs(grid,array,m,n-1));
            return array[m][n];
        }
    }
}
