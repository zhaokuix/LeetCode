package LeetCodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * 字符串解码
 */
public class DecodeString {
    /**
     * 使用栈处理加密的部分
     * 1、遇到数字开始入栈
     * 2、遇到]开始出栈，遇到数字停止出栈，计算字符串
     * 3、继续入栈，重复第2步
     */
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        //遇到数字开始入栈,直到碰到 ] 才开始出栈，遇到数字停止出栈，此时栈不为空继续入栈，遇到 ]继续此流程
        int i = 0;
        while (i < chars.length) {
            //入栈
            while (i < chars.length && ']' != chars[i]) {
                stack.push(chars[i]);
                i++;
            }
            StringBuilder tmp = new StringBuilder();
            //遇到]开始出栈
            if (i < chars.length && ']' == chars[i]) {
                //遇到数字停止出栈
                while (!stack.isEmpty() && !Character.isDigit(stack.peek())) {
                    tmp.insert(0, stack.pop());
                }
                //删除多余的 [ 符号
                tmp.delete(0, 1);
                //保存[]之间的字符串为strTmp
                String strTmp = tmp.toString();
                tmp = new StringBuilder();
                //把数字出栈，计算数字的大小
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    tmp.insert(0, stack.pop());
                }
                //字符串重复次数
                int count = Integer.parseInt(tmp.toString());
                tmp = new StringBuilder();
                //根据重复次数组装字符串
                tmp.append(strTmp.repeat(Math.max(0, count)));
                //组装后的字符入栈，寻找下一个]符号
                for (char cT : tmp.toString().toCharArray()) {
                    stack.push(cT);
                }
                i++;
            }
        }
        //将栈中字符输出
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }
}
