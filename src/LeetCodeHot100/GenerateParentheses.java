package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    /**
     * 深度优先搜索,左括号的剩余个数严格大于右括号的剩余个数时丢弃，
     * 即左括号的剩余个数必须小于或等于右括号的剩余个数才能继续组装合法的括号
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans,"", n, n);
        return ans;
    }

    /**
     * 使用递归实现深度优先遍历
     */
    public static void dfs(List<String> ans, String current,int left, int right){
        if (left == 0 && right == 0){
            ans.add(current);
            return;
        }
        //剪枝
        if (left > right){
            return;
        }
        if (left > 0){
            dfs(ans,  current + "(", left - 1,  right);
        }
        if (right > 0){
            dfs(ans,  current + ")", left,  right - 1);
        }
    }

    /**
     * 深度优先搜索,左括号的剩余个数严格大于右括号的剩余个数时丢弃，
     * 即左括号的剩余个数必须小于或等于右括号的剩余个数才能继续组装合法的括号
     *
     * 使用栈实现深度优先遍历
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        Deque<Node0> stack = new LinkedList<>();
        //压入根节点
        stack.push(new Node0("",n,n));

        while (!stack.isEmpty()){
            Node0 pop = stack.pop();
            //用完时作为结果
            if (pop.left == 0 && pop.right == 0){
                ans.add(pop.res);
            }
            //左
            if (pop.left > 0){
                stack.push(new Node0(pop.res + "(", pop.left - 1, pop.right));
            }
            //右
            if (pop.right > 0 && pop.left < pop.right){
                stack.push(new Node0(pop.res + ")", pop.left, pop.right - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis2(3));
    }
}

class Node0 {
    /**
     * 当前得到的字符串
     */
    public String res;
    /**
     * 剩余左括号数量
     */
    public int left;
    /**
     * 剩余右括号数量
     */
    public int right;

    public Node0(String str, int left, int right) {
        this.res = str;
        this.left = left;
        this.right = right;
    }
}