package LeetCodeHot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {

    /**
     * 下一个排列
     *
     * 以数字序列 [1,2,3] 为例，其排列按照字典序依次为：
     * [1,2,3]
     * [1,3,2]
     * [2,1,3]
     * [2,3,1]
     * [3,1,2]
     * [3,2,1]
     * 这样，排列 [2,3,1] 的下一个排列即为[3,1,2]。特别的，最大的排列 [3,2,1] 的下一个排列为最小的排列 [1,2,3]。
     *
     * 以[4,5,2,6,3,1]为例，它的下一个排列是[4,5,3,1,2,6]
     * 可以总结下一个排列基本规则:
     * 我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
     * 同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
     * 这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     *
     * 具体地，我们这样描述该算法，对于长度为 n 的排列 a：
     * 首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
     * 如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]。这样「较大数」即为 a[j]。
     * 交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        //左边较小的数的索引
        int i = -1;
        //右边较大的数的索引
        int j = -1;
        for (int i0 = nums.length - 2; i0 >= 0; i0--) {
            if (nums[i0] < nums[i0 + 1]) {
                i = i0;
                break;
            }
        }
        //如果i存在，在[i+1,n) 中查找第一个比a[i]大的数,并交换a[i]和a[j]
        if (i >= 0) {
            for (int i0 = nums.length - 1; i0 >= i + 1; i0--) {
                if (nums[i0] > nums[i]) {
                    j = i0;
                    break;
                }
            }
            //交换a[i]和a[j]
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            //反转区间 [i+1,n) 使其变为升序
            reverse(nums, i + 1, nums.length - 1);
        } else {
            //i不存在时，反转数组即可
            reverse(nums, 0, nums.length - 1);
        }
    }

    /**
     * 将数组转置
     * 比如将321的转置是123
     *
     * @param a     数组
     * @param start 起始位置
     * @param end   终止位置
     */
    public static void reverse(int[] a, int start, int end) {
        int middle = (start + end) / 2;
        while (start <= middle) {
            int t = a[start];
            a[start] = a[end];
            a[end] = t;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 3};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
