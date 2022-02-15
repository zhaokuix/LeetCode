package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {

    /**
     * 搜索旋转排序数组
     * 在旋转数组中搜索指定的值 ，要求时间复杂度log(n) 二分查找
     * [0,1,2,4,5,6,7] 在下标 3 处经旋转后变为 [4,5,6,7,0,1,2]。
     *
     * 示例 1：
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * 思路，使用mid和两端值比较，如果mid<right说明mid右侧是有序的，如果mid>left说明mid左侧是有序的
     * 判断目标值是否在有序区间，如果不在，在无序区间内继续查找目标值所在的有序区间，在有序区间内进行二分查找
     * @param nums 旋转的数组
     * @param target 目标值
     * @return 目标所在位置，不存在时返回-1
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] <= nums[right]){
                if (target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else if (nums[mid] >= nums[left]){
                if (target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(search(nums,3));
    }
}
