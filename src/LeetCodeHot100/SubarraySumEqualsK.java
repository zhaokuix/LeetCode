package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 和为 K 的子数组
 */
public class SubarraySumEqualsK {

    /**
     * 暴力遍历: 从每个位置出发找和为k的子数组
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
