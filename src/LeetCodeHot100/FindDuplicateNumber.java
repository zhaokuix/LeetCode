package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 寻找重复数
 */
public class FindDuplicateNumber {

    /**
     * 数组中只有一个重复的数，寻找重复的数
     * 双指针，左指指针固定，右指针遍历右侧看有没有想等的数
     * <p>
     * 超时了！！！
     */
    public int findDuplicate(int[] nums) {
        for (int left = 0; left < nums.length - 1; left++) {
            for (int right = nums.length - 1; right > left; right--) {
                if (nums[right] == nums[left]) {
                    return nums[right];
                }
            }
        }
        return -1;
    }

    /**
     * Floyd判圈算法又称龟兔赛跑算法
     * 快慢指针
     * slow
     * fast = 2*slow
     * 1、如果有环快慢指针必定相遇
     * 2、固定fast指针不动，移动slow，slow和fast下次相遇时slow的移动次数就是环的长度
     * 3、fast和slow相遇时，把fslow放到起始位置，然后两个指针都以slow的速度移动，两个指针下次相遇的节点就是环的入口
     *
     * 把数组堪称i--->nums[i]构成的有向图，因为有重复的数，那么这个有向图必定有环
     */
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        //找到slow == fast的点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        //令slow从头开始
        slow = 0;
        //然后两个指针都以slow的速度移动，两个指针下次相遇的节点就是环的入口
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
