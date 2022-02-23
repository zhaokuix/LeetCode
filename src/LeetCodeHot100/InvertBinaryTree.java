package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    /**
     * 反转二叉树
     * 所有二叉树的问题，只看一个简单的三个节点的就可以，
     * 1、我希望左子树给我什么 递归
     * 2、我希望右子树给我什么 递归
     * 3、处理左右子树
     * 此题是需要：将左子树换成右子树，右子树换成左子树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        //我需要左子树
        TreeNode left = invertTree(root.left);
        //我需要右子树
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
