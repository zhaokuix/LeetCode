package LeetCodeHot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 滑动窗口最大值
 */
public class SlidingWindowMaximum {
    /**
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * 暴力求解
     * max[i] = max(nums[i],nums[i+1],...,nums[i+k-1])
     *
     * 时间复杂度O(kn)超时了！！！！
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length -k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int tmp = nums[i];
            //求max(nums[i],nums[i+1],...,nums[i+k-1])
            for (int j = i; j < nums.length && j < i + k; j++) {
                tmp = Math.max(nums[j], tmp);
            }
            max[i] = tmp;
        }
        return max;
    }

    /**
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * 使用双向队列存储下标滑动窗口内的最大值下标，减少暴力求解的次数
     * 时间复杂度O(2n)
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] max = new int[nums.length -k + 1];
        //双端队列存储最大值的下标
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //取出比nums[i]小的数据再放入nums[i]的下标
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            //存入数据的下标
            deque.addLast(i);
            //判断当前队列中队首的值是否在[i - k + 1,i]内，如果不在要删除
            if (deque.getFirst() <= i - k){
                deque.removeFirst();
            }
            //因为是从0开始遍历的，当i+1>=k时才能开始放置数据
            if (i + 1 >= k){
                max[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow1(nums,3)));
    }
}
