package LeetCodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 每日温度
 */
public class DailyTemperatures {
    /**
     * 方法一：暴力遍历
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    /**
     * 方法一：单调栈
     * 栈为空时，将数组下标入栈。
     * 栈不为空时，如果temperatures[i] > temperatures[peek()],将peek出栈,更新answer[peek()] = i - peek() 出栈（循环判断)
     * 其他情况，i入栈
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        return answer;
    }
}
