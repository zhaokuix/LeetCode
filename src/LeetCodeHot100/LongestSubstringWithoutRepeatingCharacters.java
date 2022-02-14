package LeetCodeHot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 无重复字符的最长子串---滑动窗口
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * <p>
     * 我们先用一个例子考虑如何在较优的时间复杂度内通过本题。
     * 我们不妨以示例一中的字符串 abcabcbb 为例，找出从每一个字符开始的，不包含重复字符的最长子串，
     * 那么其中最长的那个字符串即为答案。对于示例一中的字符串，
     * 我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
     * <p>
     * 以(a)bcabcbb 开始的最长字符串为 (abc)abcbb；
     * 以a(b)cabcbb 开始的最长字符串为 a(bca)bcbb；
     * 以ab(c)abcbb 开始的最长字符串为 ab(cab)cbb；
     * 以abc(a)bcbb 开始的最长字符串为 abc(abc)bb；
     * 以abca(b)cbb 开始的最长字符串为 abca(bc)bb；
     * 以abcab(c)bb 开始的最长字符串为 abcab(cb)b；
     * 以abcabc(b)b 开始的最长字符串为 abcabc(b)b；
     * 以abcabcb(b) 开始的最长字符串为 abcabcb(b)。
     * 发现了什么？如果我们依次递增地枚举子串的起始位置，那么子串的结束位置也是递增的！
     * 这里的原因在于，假设我们选择字符串中的第 k 个字符作为起始位置，
     * 并且得到了不包含重复字符的最长子串的结束位置为 rk。
     * 那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 rk
     * 的字符显然是不重复的，并且由于少了原本的第 k 个字符，我们可以尝试继续增大 rk，直到右侧出现了重复字符为止。
     * <p>
     * 这样一来，我们就可以使用「滑动窗口」来解决这个问题了：
     * <p>
     * 我们使用两个指针表示字符串中的某个子串（或窗口）的左右边界，其中左指针代表着上文中「枚举子串的起始位置」，而右指针即为上文中的 rk；
     * <p>
     * 在每一步的操作中，我们会将左指针向右移动一格，表示 我们开始枚举下一个字符作为起始位置，然后我们可以不断地向右移动右指针，
     * 但需要保证这两个指针对应的子串中没有重复的字符。在移动结束后，这个子串就对应着 以左指针开始的，不包含重复字符的最长子串。
     * 我们记录下这个子串的长度；
     * <p>
     * 在枚举结束后，我们找到的最长的子串的长度即为答案。
     * <p>
     * 判断重复字符:
     * 在上面的流程中，我们还需要使用一种数据结构来判断 是否有重复的字符，常用的数据结构为哈希集合（即 C++ 中的 std::unordered_set，Java 中的 HashSet，Python 中的 set, JavaScript 中的 Set）。
     * 在左指针向右移动的时候，我们从哈希集合中移除一个字符，在右指针向右移动的时候，我们往哈希集合中添加一个字符。
     * 至此，我们就完美解决了本题。
     */
    public static int lengthOfLongestSubstring(String s) {
        //最长子序列的长度
        int ans = 0;
        //左指针
        int k = 0;
        //右指针
        int rk = 0;
        Set<Character> set = new HashSet<>();
        for (; k < s.length(); k++) {
            //删除上次枚举计算长度时，左指针位置的数据
            if (k > 0) {
                set.remove(s.charAt(k - 1));
            }
            //右指针遍历，只要set中没有，一直遍历
            while (rk < s.length() && !set.contains(s.charAt(rk))) {
                set.add(s.charAt(rk));
                rk++;
            }
            //找长度最大的值
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    /**
     * 使用ASCII码索引
     * 以这个字符串为例：abcabcbb，当i等于3时，也就是指向了第二个a,
     * 此时我就需要查之前有没有出现过a, 如果出现了是在哪一个位置出现的。
     * 然后通过last[index] 查到等于 0, 也就是说，如果start 依然等于0的话，那么当前窗口就有两个a了，
     * 也就是字符串重复了，所以我们需要移动当前窗口的start指针，移动到什么地方呢？移动到什么地方，窗口内就没有重复元素了呢？
     * 对了，就是a上一次出现的位置的下一个位置，就是0 + 1 = 1。当start == 1,
     * 当前窗口就没有了重复元素，那么以当前字符为结尾的最长无重复子串就是bca,
     * 然后再和之前的res取最大值。然后i指向后面的位置，按照同样思路计算。
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 记录字符上一次出现的位置，小写字母的ASCII码没有大于128的，所以可以用一个长度为128的数组的下标作为字母的索引
        int[] last = new int[128];
        //初始化为-1
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        //最大长度
        int res = 0;
        //滑动窗口开始的位置
        int start = 0;
        for (int i = 0; i < n; i++) {
            //获取当前字母的ASCII码
            int index = s.charAt(i);
            //last[index] + 1 该字母上次出现的位置+1，作为新的开始位置
            start = Math.max(start, last[index] + 1);
            //计算长度
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
