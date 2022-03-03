package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *  合并二叉树
 */
public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        } else if (root1 == null && root2 != null){
            root1 = root2;
        } else if (root2 != null && root1 != null){
            root1.val = root1.val + root2.val;
            root1.left = mergeTrees(root1.left,root2.left);
            root1.right = mergeTrees(root1.right,root2.right);
        }
        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        mergeTrees(root1,root2);
    }
}
