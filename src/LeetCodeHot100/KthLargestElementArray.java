package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementArray {

    /**
     * 方法一：使用快速排序排序后再计算
     */
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (--k == 0){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 快速排序
     */

    public void quickSort(int[] nums){
        sort(nums,0,nums.length - 1);
    }
    public void sort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int l = left, r = right;
        int x = nums[left];
        while (left < right){
            //从右向左找到第一个小于x的数
            while (left < right && nums[right] > x){
                right--;
            }
            if (left < right){
                nums[left] = nums[right];
                left++;
            }
            //从左向右找到第一个大于x的数
            while (left < right && nums[left] < x){
                left++;
            }
            if (left < right){
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = x;
        sort(nums,l, left - 1);
        sort(nums,left + 1, r);
    }

    /**
     * 方法二：使用快速排序思想，进行倒序排序，下标为k-1的数就是要找的数
     */
    public static int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums,0,nums.length - 1, k-1);
    }

    /**
     *快速选择
     */
    public static int quickSelect(int[] nums, int left, int right, int index){
        if (left <= right){
            int l = left, r = right;
            int x = nums[l];
            while (l < r){
                //从右向左找到第一个大于x的数
                while (l < r && nums[r] < x){
                    r--;
                }
                //放到左边
                if (l < r){
                    nums[l] = nums[r];
                    l++;
                }
                //从左向右找到第一个小于x的数
                while (l < r && nums[l] > x){
                    l++;
                }
                //放到右边
                if (l < r){
                    nums[r] = nums[l];
                    r--;
                }
            }
            nums[l] = x;
            if (l == index){
                return x;
            }else if (l > index){
                //遍历左边
                return quickSelect(nums,left, l -1, index);
            }else {
                //遍历右边
                return quickSelect(nums,l + 1, right, index);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest1(nums,4));
    }
}
