package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {

    /**
     * 单词搜索，回溯法：相比于DFS，多了一步『撤销修改节点状态』
     * 思路：
     * 遍历board,从[i,j]位置向上下左右搜索，如果能匹配完word，就返回true
     * ！！！！！用一个二维数组表示移动方向
     * int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
     */
    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        //字母记录有没有被用过
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean f = check(board, visited, wordChar, i, j, 0);
                if (f) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, char[] word, int i, int j, int k) {
        //终止条件
        if (board[i][j] != word[k]) {
            //不匹配直接返回false
            return false;
        } else if (k == word.length - 1) {
            //匹配并且word遍历结束了，返回true
            return true;
        }
        //访问过了
        visited[i][j] = true;
        boolean result = false;
        //声明一个数组代表移动方向，可以向上下左右移动
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            if (newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length && !visited[newI][newJ]){
                boolean check = check(board, visited, word, newI, newJ, k + 1);
                if (check) {
                    result = true;
                    break;
                }
            }
        }
        //状态重置
        visited[i][j] = false;
        return result;
    }
}
