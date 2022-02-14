package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    /**
     * 解法一，暴力遍历,时间复杂度O(n^2)
     * @param nums 数组
     * @param target 目标
     * @return 数字下标
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 解法二、使用hashmap，时间复杂度O(n)
     * @param nums 数组
     * @param target 目标
     * @return 数字下标
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(32);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k) && k != nums[i]){
                return new int[]{i, map.get(k)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }
}
