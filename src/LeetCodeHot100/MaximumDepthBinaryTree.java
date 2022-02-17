package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthBinaryTree {

    /**
     * 二叉树的最大深度
     * 层序遍历确定深度
     *
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //记录该层的节点数
        int count;
        while (!queue.isEmpty()){
            ans++;
            count = queue.size();
            while (count > 0){
                TreeNode poll = queue.poll();
                if (poll.left != null){
                    queue.add(poll.left);
                }
                if (poll.right != null){
                    queue.add(poll.right);
                }
                --count;
            }
        }
        return ans;
    }
}
