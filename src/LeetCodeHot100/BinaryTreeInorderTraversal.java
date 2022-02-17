package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    /**
     * 中序遍历 左根右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal0(root,ans);
        return ans;
    }
    /**
     * 递归方法
     */
    public void inorderTraversal0(TreeNode root, List<Integer> ans){
        if (root == null){
            return;
        }
        if (root.left != null){
            inorderTraversal0(root.left,ans);
        }
        ans.add(root.val);
        if (root.right != null){
            inorderTraversal0(root.right,ans);
        }
    }

    /**
     * 中序遍历 左根右 栈遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            root = pop.right;
        }
        return ans;
    }
}
