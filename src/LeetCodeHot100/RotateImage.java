package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problemset/all/?listId=2cktkvj&page=1
 */
public class RotateImage {

    /**
     * 旋转图像 先转置再对折
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * 1,2,3         7,4,1
     * 4,5,6  旋转后  8,5,2
     * 7,8,9         9,6,3
     * 旋转过程：
     * 先按1--9对折得到（转置）
     * 1,4,7
     * 2,5,8
     * 3,6,9
     * 再按4---6对折
     * 7,4,1
     * 8,5,2
     * 9,6,3
     *
     * @param matrix 二维数组
     */
    public static void rotate(int[][] matrix) {
        //先转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        //再对折
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int tem = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = matrix[i][j];
                matrix[i][j] = tem;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
