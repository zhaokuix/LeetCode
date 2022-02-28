package LeetCodeHot100;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 前 K 个高频元素
 */
public class TopKFrequentElements {
    /**
     * 使用map计算次数
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
