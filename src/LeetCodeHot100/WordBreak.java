package LeetCodeHot100;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    /**
     * 单词拆分
     * 判断wordDict中的字符串能否组合出s
     *
     * 动态规划:s的前i个字符能不能匹配上上用dp[i]表示，dp[i]能不能是true取决于[0,i]拆分能不能拆分成单词。
     * dp[i] = dp[j]&&check[j,i]，其中0<=j<=i,只要j存在，dp[i]就是true
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                //dp[i] = dp[j]&&check[j,i]，其中0<=j<i;
                if (dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s = "ddadddbdddadd";
        List<String> dict = Arrays.asList("dd","ad","da","b");
        System.out.println(wordBreak(s,dict));
    }
}
