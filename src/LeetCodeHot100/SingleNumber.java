package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，
     * 其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 异或运算符的使用
     *
     * 异或运算符（^）的规则
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数与0异或为任何数 0 ^ n => n
     * 相同的数异或为0: n ^ n => 0
     * 不同的数异或为1: x ^ y =>1
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        return ans;
    }
}
