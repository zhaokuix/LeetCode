package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {
    /**
     * 返回数组的全排列
     *
     * Example 1:
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, ans, path, visited);
        return ans;
    }
    public static void dfs(int[] nums,List<List<Integer>> ans, List<Integer> path, boolean[] visited){
        //回溯终止条件
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        //每次都是从0开始回溯
        for (int i = 0; i < nums.length; i++) {
            //用过的数字不能再次使用
            if (visited[i]){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums,ans, path, visited);
            //状态重置
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
