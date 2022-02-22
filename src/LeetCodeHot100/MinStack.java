package LeetCodeHot100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 方法一：辅助栈，辅助栈存当前元素对应的最小值，弹出时同时弹出
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
        } else {
            stack.push(val);
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
