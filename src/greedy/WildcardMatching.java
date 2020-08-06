package greedy;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    /**
     * 贪心算法
     * 思路分析，此问题的关键是*,可以按*分割字符串，分段匹配，匹配不上即返回false
     * 用 sIndex 和 pIndex 表示当前遍历到 s 和 p 的位置
     * 此时我们正在 s 中寻找某个 u_i
     * 其在 s 和 p 中的起始位置为 sRecord 和 pRecord
     * sRecord 和 pRecord 的初始值为 −1，表示模式 p 的开头字符不是星号
     * 需要注意的点：
     * 如果模式 p 的结尾字符不是星号，那么就必须与字符串 s 的结尾字符匹配。
     * 那么我们不断地匹配 s 和 p 的结尾字符，直到 p 为空或者 p 的结尾字符是星号为止。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*'){//p 的结尾字符不是星号,时倒着匹配字符直到遇到星号，或者不匹配返回false
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))){
                --sRight;
                --pRight;
            }else {//在遇到*号之前字符不匹配，返回false
                return false;
            }
        }
        if (pRight == 0){//如果p长度是0，看s是不是0，是0返回true，不是返回false
            return sRight == 0;
        }
        int sIndex = 0, pIndex = 0;//当前遍历到s和p的位置
        int sRecord = -1, pRecord = -1;//s和p这一段字符的起始遍历位置，默认为-1，默认p第一个字符不是*号
        while (sIndex < sRight && pIndex < pRight){
            if (p.charAt(pIndex) == '*'){//如果当前字符是*号，跳过当前字符,并修改起始遍历位置
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            }else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))){//如果字符匹配继续循环即可
                ++pIndex;
                ++sIndex;
            }else if (sRecord != -1 && sRecord + 1 < sRight){
                // 如果两个字符不匹配，那么需要重新寻找 u_i
                // 枚举下一个 s 中的起始位置
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            }else {//如果两个不匹配并且s的下一个位置为空，说明匹配失败，返回false
                return false;
            }
        }
        // 由于 p 的最后一个字符是星号，那么 s 未匹配完，那么没有关系
        // 但如果 p 没有匹配完，那么 p 剩余的字符必须都是星号
        return allStars(p, pIndex, pRight);
    }
    public boolean allStars(String str, int left, int right){
        for (int i = left; i < right; i++) {
            if (str.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }
    public boolean charMatch(char u, char v) {
        return  u == v || v == '?';
    }

    public static void main(String[] args) {
    }
}
