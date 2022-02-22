package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    /**
     * 投票算法：
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 因为总是存在多数元素，可以设一个变量count,遇到相同的就+1，遇到不同的就-1，
     * 减到0就重新换个数开始计数，总能找到最多的那个
     * 0前面的数不用考虑，相当于兑掉了.
     *
     * 投票算法证明：
     * 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
     * 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];
        for (int num : nums) {
            if (num == ans) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    ans = num;
                    count = 1;
                }
            }
        }
        return ans;
    }
}
