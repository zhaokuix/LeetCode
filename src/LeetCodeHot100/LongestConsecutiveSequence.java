package LeetCodeHot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    /**
     * 方法一：先排序再查找。不满足时间复杂度O(n)
     *
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int ans = 1;
        int current = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1){
                ++current;
            }else if (nums[i] == nums[i + 1]){
                continue;
            }else {
                current = 1;
            }
            ans = Math.max(ans,current);
        }
        return ans;
    }

    /**
     * 方法二：使用hashset，空间换时间，满足时间复杂度O(n)
     *
     */
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int ans = 0;
        Set<Integer> set  = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int length = 1;
            //set中存在连续的数
            if (set.contains(nums[i] +1)){
                set.remove(nums[i]);
                int t1 = nums[i];
                //向右查找
                while (set.contains(++t1)){
                    ++length;
                    set.remove(t1);
                }
                int t2 = nums[i];
                //向左查找
                while (set.contains(--t2)){
                    ++length;
                    set.remove(t2);
                }
            }
            ans = Math.max(length,ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive1(nums));
    }
}
