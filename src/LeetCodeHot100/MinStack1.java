package LeetCodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 不使用辅助栈时，用变量存当前最小值，栈内存和最小值的差值
 * 注意差值可能超过int的范围，所以要用Long声明栈
 * 入栈时，计算差值，计算当前min
 * 出栈时，如果差值是正数，返回min+stack.pop，此时上一个 min = min
 * 如果差值是负数，说明min就是要返回的值，此时上一个 min = min - stack.pop
 */
public class MinStack1 {
    Deque<Long> stack;
    long min;

    public MinStack1() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            //如果x是最小的数，这里可能越界，所以用Long来保存
            stack.push(val - min);
            min = Math.min(val, min);
        }
    }

    public void pop() {
        Long pop = stack.pop();
        if (pop >= 0) {
            //return min + pop;
        } else {
            long res = min;
            min = (int) (min - pop);
            //return res;
        }
    }

    public int top() {
        Long peek = stack.peek();
        if (peek >= 0) {
            return (int) (min + peek);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
