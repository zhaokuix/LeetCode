package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 * 汉明距离
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 */
public class HammingDistance {
    /**
     * 方法一：使用异或运算符后使用Integer内置的bitCount方法计算1的个数
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
    /**
     * 方法二：每次都分别将这两个整型右移1位，然后取低位比较，计算不同的位数的个数
     */
    public int hammingDistance1(int x, int y) {
        int count = 0;
        //int是四个字节，32位
        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)){
                count++;
            }
            x >>= 1;
            y >>= 1;
        }
        return count;
    }

}
