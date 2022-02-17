package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    /**
     * 方法一：深度优先搜索
     * 直接dfs会超时
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        List<Integer> ansList = new ArrayList<>(1);
        ansList.add(0);
        dfs(ansList,m-1,n-1);
        return ansList.get(0);
    }
    public static void dfs(List<Integer> ans, int m, int n){
        //走完后都变成0
        if (m == 0 && n == 0){
            ans.set(0,ans.get(0) + 1);
            return;
        } else if (m == 0 && n != 0){
            //m走完了，只走n
            dfs(ans, m, n-1);
        }else if (m != 0 && n == 0){
            //n走完了只走m
            dfs(ans, m-1, n);
        }else if (m !=0 && n != 0){
            //m和n都没走完，都可以继续走
            //向右走
            dfs(ans, m, n-1);
            //向下走
            dfs(ans, m-1, n);
        }
    }

    /**
     * 记忆化dfs，不会超时
     */
    public static int uniquePaths2(int m, int n) {
        int[][] array = new int[m][n];
        return dfs2(array,m-1,n-1);
    }
    public static int dfs2(int[][] array,int m, int n){
        //如果已经计算过了直接返回结果
        if (array[m][n] != 0){
            return array[m][n];
        }
        //m或n走完后只剩一条路，返回1即可
        if (m == 0 || n == 0){
            array[m][n] = 1;
        } else {
            array[m][n] =  dfs2(array,m - 1, n) + dfs2(array,m, n - 1);
        }
        return array[m][n];
    }

    /**
     * 方法二：动态规划
     * 到(i,j)的路径数量等于到(i-1,j)的路径数量加到(i,j-1)的路径数量
     * dp[i,j] = dp[i-1,j] + dp[i,j-1];
     */
    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3,7));
    }

}
