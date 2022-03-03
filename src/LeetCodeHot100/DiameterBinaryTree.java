package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 二叉树的直径
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterBinaryTree {

    /**
     * 遍历每个节点求左右子节点的最大高度，然后求和
     */
    static int  max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
       dfs(root);
        return max;
    }
    //求左右子节点高度和
    public static int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null){
            //左子树高度
            left = dfs(root.left) + 1;
        }
        if (root.right != null){
            //右子树高度
            right = dfs(root.right) + 1;
        }
        //节点的直径长度
        max = Math.max(max,right + left);
        //节点的高度
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
}
