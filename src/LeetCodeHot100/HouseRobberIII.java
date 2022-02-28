package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 打家劫舍 III
 */
public class HouseRobberIII {
    /**
     * 动态规划：
     * 设对于节点i
     * f(i)表示i被选中时所能获得的最大金额，g(i)表示i不被选中时所能获得的最大金额
     * i被选中时左右子节点均不能被选中，因此
     * f(i) = g(left) + g(right) + i
     * i不被选中时，左右子节点可以选中也可以不选中，取二者最大值即可
     * g(i) = max(g(left),f(left)) + max(g(right),f(right))
     * 用map来存储不同节点的f(i)和g(i),遍历一遍二叉树，从底向上计算，根节点的f(root)或者g(root)就是我们要求的最大值
     */
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> f = new HashMap<>();
        HashMap<TreeNode, Integer> g = new HashMap<>();
        dfs(root, f, g);
        return Math.min(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root, HashMap<TreeNode, Integer> f, HashMap<TreeNode, Integer> g) {
        if (root == null) {
            return;
        }
        dfs(root.left, f, g);
        dfs(root.right, f, g);
        f.put(root, g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0) + root.val);
        g.put(root, Math.max(g.getOrDefault(root.left, 0), f.getOrDefault(root.left, 0)) +
                Math.max(g.getOrDefault(root.right, 0), f.getOrDefault(root.right, 0)));
    }
}
