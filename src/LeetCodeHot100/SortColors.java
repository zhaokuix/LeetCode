package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class SortColors {

    /**
     * 遍历一遍数一下有几个2几个1几个0，重新设置一下即可
     * @param nums
     */
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == 0){
                ++count0;
            }else if (num == 1){
                ++count1;
            }else if (num == 2){
                ++count2;
            }
        }
        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for (int i = count0; i < count1 + count0; i++) {
            nums[i] = 1;
        }
        for (int i = count1 + count0; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}
