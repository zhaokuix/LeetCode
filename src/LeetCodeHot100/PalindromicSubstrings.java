package LeetCodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 回文子串
 */
public class PalindromicSubstrings {

    /**
     * 方法一：枚举每一个子串判断是不是回文子串，时间复杂度O(n^3)
     */
    public int countSubstrings(String s) {
        int ans = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j <= l; j++) {
                if (check(s.substring(i, j))) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 使用栈判断一个字符串是不是回文子串,时间复杂度O(n^2)
     */
    public boolean check(String s) {
        if (s.length() == 1) {
            return true;
        }
        int length = s.length();
        //左、右指针判断是不是回文子串
        int left, right;
        //如果是奇数left=right=length / 2
        if ((length & 1) == 1) {
            left = length / 2;
            right = left;
        } else {
            //如果是偶数right=length / 2，left = right - 1
            right = length / 2;
            left = right - 1;
        }
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return left == -1 && right == length;
    }

    /**
     * 方法一：枚举每一个中心点，判断是不是回文子串。
     * 回文串长度是奇数时，中心点是一个，回文串长度是偶数时中心点是两个。
     */
    public int countSubstrings1(String s) {
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            //分别枚举奇数/偶数的情况
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < length && s.charAt(left--) == s.charAt(right++)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        String s = "abc";
        System.out.println(palindromicSubstrings.countSubstrings(s));
    }
}
