package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 *Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {

    /**
     * 暴力遍历，时间复杂度O(n^3)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //使用Set去重
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        if (nums.length < 3){
            return new ArrayList<>(answer);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int three = -(nums[i] + nums[j]);
                if (numsList.contains(three) && numsList.indexOf(three) != i && numsList.indexOf(three) != j){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], three);
                    Collections.sort(list);
                    answer.add(list);
                }
            }
        }
        return new ArrayList<>(answer);
    }

    /**
     * 方法二、排序+双指针
     * @param nums 数组
     * @return list集合
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> target = new HashSet<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            //左指针
            int l = i + 1;
            //右指针
            int r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    target.add(list);
                    l++;
                    r--;
                }else if (sum > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return new ArrayList<>(target);
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
