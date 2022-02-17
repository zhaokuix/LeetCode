package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else {
            return helper(root.left, root.right);
        }
    }

    public boolean helper(TreeNode left, TreeNode right) {
        //递归的终止条件是两个节点都为空
        //或者两个节点中有一个为空
        //或者两个节点的值不相等
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
