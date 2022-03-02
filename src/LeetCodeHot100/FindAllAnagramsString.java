package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 找到字符串中所有字母异位词
 */
public class FindAllAnagramsString {
    /**
     * 在s中截取所有p长度的字符串,排序，判断截取后的是不是p的字母异位词
     */
    public static List<Integer> findAnagrams(String s, String p) {

        int pLength = p.length();
        //排序p
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        String newP = new String(pCharArray);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= s.length() - pLength; i++) {
            String tmpString = s.substring(i, i + pLength);
            //排序tmpString
            char[] chars = tmpString.toCharArray();
            Arrays.sort(chars);
            String newTmp = new String(chars);
            //判断排序后的字符串是否和排序后的p相等
            if (newP.equals(newTmp)) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     * sCount每增加一个新字母，需要删除最左边的字母
     * 判断sCount是不是和pCount相等即可
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int pLength = p.length();
        //因为都是小写字母可以根据字符的数量比较
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        //先比较前pLength个字母，构建窗口
        for (int i = 0; i < p.toCharArray().length; i++) {
            ++pCount[p.charAt(i) - 'a'];
            ++sCount[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = pLength; i < s.length(); i++) {
            //sCount增加一个字母
            ++sCount[s.charAt(i) - 'a'];
            //删掉最左侧的字母
            --sCount[s.charAt(i - pLength) - 'a'];
            //字母数量相同，加入起始index
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - pLength + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams1(s, p));
    }
}
