package LeetCodeHot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 */
public class ValidParentheses {
    /**
     *方法一：开心消消乐
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0){
            return false;
        }
        while (s.length() > 0){
            String t = s;
            s = s.replaceAll("\\(\\)","")
                    .replaceAll("\\[]","")
                    .replaceAll("\\{}","");
            if (t.equals(s)){
                return false;
            }
        }
        return true;
    }

    /**
     *方法二：使用Stack
     * 如果遇到右括号，那么栈顶必定是左括号，如果不是，校验不通过。
     */
    public static boolean isValid2(String s) {
        //字符串长度是奇数时直接返回false
        if (s == null || s.length() % 2 != 0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        //右括号集合
        Set<Character> keySet = map.keySet();
        //Deque声明一个栈
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            //如果是右括号，栈顶一定是左括号，如果栈顶不是左括号，返回false
            if (keySet.contains(c)){
                //栈顶出栈并判断是否为左括号
                if (stack.isEmpty() || map.get(c) != stack.pop()){
                    return false;
                }
            }else {
                //左括号入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "){";
        System.out.println(isValid2(s));
    }
}
