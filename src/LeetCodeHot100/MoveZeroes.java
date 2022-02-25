package LeetCodeHot100;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 移动零
 */
class MoveZeroes {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * 遍历时计算0的个数，0的个数就是遇到非零元素时，非零元素要移动的次数
     * 最后：置零最后几个元素
     *
     */
    public static void moveZeroes(int[] nums) {
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i - countZero] = nums[i];
            if (nums[i] == 0){
                countZero++;
            }
            if (countZero > 0){
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}