package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {

    /**
     * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * 示例1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 对于位置i,i能跳到的最远的位置为 i+nums[i]
     * 对于位置j，j>i，必须满足j<=i+nums[i],那么才能跳到j。
     * 因此只要存在i,满足i+nums[i]>=nums.length-1就可以跳到最后一个下标
     */
    public static boolean canJump(int[] nums) {
        int maxJump = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //maxJump>=i时才可以跳到i，否则直接返回false
            if (maxJump >= i){
                maxJump = Math.max(maxJump,nums[i] + i);
            }else {
                return false;
            }
            //优化速度,只要最远距离大于等于nums.length - 1，就可以返回true
            if (maxJump >= nums.length - 1){
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums1 = {3,2,1,0,4};
        System.out.println(canJump(nums1));
    }
}
