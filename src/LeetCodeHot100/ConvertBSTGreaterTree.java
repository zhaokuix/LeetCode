package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，
 * 请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 */
public class ConvertBSTGreaterTree {
    /**
     * 方法一：遍历每个节点计算值
     */
    public TreeNode convertBST(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        dfs(root, root, map);
        //遍历设置值
        dfsSetValue(root,map);
        return root;
    }

    public void dfsSetValue(TreeNode root, Map<TreeNode, Integer> map){
        if (root == null){
            return;
        }
        root.val = map.get(root);
        dfsSetValue(root.left,map);
        dfsSetValue(root.right,map);
    }

    int sum = 0;
    public void dfs(TreeNode node, TreeNode root, Map<TreeNode, Integer> map) {
        if (node == null) {
            return;
        }
        sum = 0;
        sumTree(root, node.val);
        map.put(node, sum + node.val);
        dfs(node.left, root, map);
        dfs(node.right, root, map);
    }

    public void sumTree(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.val > target) {
            sum = root.val + sum;
        }
        sumTree(root.right, target);
        sumTree(root.left, target);
    }

    /**
     * 方法二：因为是二叉搜索树，右子树的值比左子树大，可以用反中序遍历计算节点值，遍历过程中记录节点和
     */
    int total = 0;
    public TreeNode convertBST1(TreeNode root) {
        if (root != null){
            convertBST1(root.right);
            total = total + root.val;
            root.val = total;
            convertBST1(root.left);
        }
        return root;
    }
}
