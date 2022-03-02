package LeetCodeHot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 找到所有数组中消失的数字
 */
public class FindAllNumbersDisappearedArray {
    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
     * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字。
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                answer.add(i);
            }
        }
        return answer;
    }

    /**
     * 将所有正数作为数组下标，置对应数组值为负值。
     * 那么，仍为正数的位置即为（未出现过）消失的数字。
     * 举个例子：
     * 原始数组：[4,3,2,7,8,2,3,1]
     * 重置后为：[-4,-3,-2,-7,8,2,-3,-1]
     * 结论：[8,2] 分别对应的index为[5,6]（消失的数字）
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                answer.add(i + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers1(nums));
    }
}
