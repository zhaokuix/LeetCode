package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    /**
     * 输出集合所有子集
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     *
     * dfs记录所有结果
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums,ans,new ArrayList<>(),0);
        return ans;
    }
    public void dfs(int[] nums,List<List<Integer>> ans,List<Integer> list,int left){
        ans.add(new ArrayList<>(list));
        for (int i = left; i < nums.length; i++) {
            list.add(nums[i]);
            //用过的数字不能再用了，下次从i+1开始
            dfs(nums,ans,list,i + 1);
            //状态重置
            list.remove(list.size() - 1);
        }
    }
}
