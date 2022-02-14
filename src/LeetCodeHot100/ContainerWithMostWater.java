package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    /**
     * 暴力穷举法，会超时
     * @param height 高度
     * @return 面积
     */
    public static int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                //取height[i]和height[j]中较小的数进行计算
                int h = Math.min(height[i],height[j]);
                //面积等于h*(j-i)
                int s = h * ( j - i );
                ans = Math.max(ans,s);
            }
        }
        return ans;
    }

    /**
     * 双指针，一个指针在左侧，一个指针在最右侧，计算面积。
     * 移动较小的指针，再次计算，再移动较小的指针再计算，当两个指针重合，计算完毕，求最大值即可
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right){
            //计算面积
            int h = Math.min(height[left], height[right]);
            ans = Math.max(ans, h * (right - left));
            if (height[left] <= height[right]){
                ++left;
            }else {
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height1 = {1,1};
        int[] height2 = {1};
        System.out.println(maxArea1(height2));
    }
}
