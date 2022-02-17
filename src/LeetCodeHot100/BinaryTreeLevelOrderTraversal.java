package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 二叉树的层序遍历
     * 使用队列进行层序遍历
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //记录该层的节点数
        int count;
        while (!queue.isEmpty()){
            count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
                --count;
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
