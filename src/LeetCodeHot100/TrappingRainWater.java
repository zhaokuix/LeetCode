package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    /**
     * 接雨水
     * 对于下标 i，下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，
     * 下标 i 处能接的雨水量等于下标 i 处的水能到达的最大高度减去height[i]。
     * 动态规划，维护两个数组left[i]、right[i]，先从做往右计算最大高度，再从右往左计算最大高度，
     * 下雨后水能到达的最大高度等于下标 i 两边的最大高度的最小值，所存雨水量为min(left[i],right[i])。
     */
    public static int trap(int[] height) {
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        //从左往右计算i的最大高度
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        right[height.length - 1] = height[height.length - 1];
        //从右往左计算i的最大高度
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        //计算雨水
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4};
        System.out.println(trap(height));
    }
}
