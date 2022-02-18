package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeLinkedList {
    /**
     * 二叉树展开为链表
     *
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * @param root
     */
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode treeNode = new TreeNode();
        traversal(list,root);
        for (TreeNode node : list) {
            treeNode.right = node;
            treeNode.left = null;
            treeNode = treeNode.right;
        }
    }

    /**
     *先序遍历 根---左---右
     */
    public static void traversal(List<TreeNode> list, TreeNode root){
        if (root == null){
            return;
        }
        list.add(root);
        traversal(list, root.left);
        traversal(list, root.right);
    }

    public static void main(String[] args) {

    }
}
