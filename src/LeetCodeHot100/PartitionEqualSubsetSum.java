package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 分割等和子集
 */
public class PartitionEqualSubsetSum {

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 背包问题变形，本题可以看成能否从数组中选几个数，使其和变成数组总和的一半
     * 1、对于总和是奇数的，肯定不能平分，因此只考虑偶数即可
     * 2、对于数组数量小于2的，肯定不能均分
     * 3、最大值大于数组总和的一半时，不能平分
     * 令dp[i][j]为从前i个数中能否选几个数组成j，默认为false
     * 当选i时，dp[i][j]要为true,那么dp[i-1][j-nums[i]]必须为true，dp[i][j] = dp[i-1][j-nums[i]];
     * 当不选i时，dp[i][j]要为true,那么dp[i-1][j]必为true，可以理解为前i-1个数已经能组成j了
     * 边界值：
     * i = 0,全都不选时，dp[0][j] = false
     * j = 0,时dp[i][j] = false
     * 对于dp[0][0],需要设置为true,代表全都不选，不进行求和
     */
    public static boolean canPartition(int[] nums) {

        int sum = 0;
        int max = 0;
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean chooseI = false;
                boolean noI = false;
                if (j - nums[i - 1] >= 0) {
                    //选i时,j - nums[i - 1]必须大于等于0才能选
                    chooseI = dp[i - 1][j - nums[i - 1]];
                }
                //不选i时
                noI = dp[i-1][j];
                //只要有一个能true就是true
                dp[i][j] = chooseI || noI;
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6,7};
        System.out.println(canPartition(nums));;
    }
}
