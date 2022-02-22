package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿数量
 */
public class Numberslands {

    /**
     * 岛屿数量
     * 遍历二维数组，遇到1就进行深度优先搜索，遍历所有的1，并标记为0，岛屿数+1
     * 然后找下一个1;
     */
    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }


    public static void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        int[][] direct = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int[] d : direct) {
            dfs(grid,i + d[0], j + d[1]);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }
}
