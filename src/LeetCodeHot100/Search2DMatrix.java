package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DMatrix {
    /**
     * 编写一个高效的算法来搜索矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 遍历每行二分查找
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] m : matrix) {
            if (binarySearch(m,target,0,m.length)){
                return true;
            }
        }
        return false;
    }
    /**
     * 前置知识：
     * 有序数组二分查找
     */
    public static boolean binarySearch(int[] nums, int target, int left, int right) {
        if (nums.length == 0 || left > right || left >= nums.length || right < 0 ) {
            return false;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, left, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, right);
        }
    }

    /**
     * [1, 4, 7, 11, 15],
     * [2, 5, 8, 12, 19],
     * [3, 6, 9, 16, 22],
     * [10,13,14,17, 24],
     * [18,21,23,26, 30]
     *
     * target = 5
     * 可以从左下角向右上角搜索
     * 如果matrix[x][y] > target
     * 说明x行都比他大，舍掉x行 x = x - 1
     * 如果matrix[x][y] < target
     * 说明y列都比他小舍掉y列 y= y + 1
     *
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length){
            if (matrix[x][y] == target){
                return true;
            } else if (matrix[x][y] > target){
                x = x - 1;
            }else {
                y = y +1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] matrix = {{1,1,2}};
        System.out.println(searchMatrix1(matrix, -2));
    }

}
