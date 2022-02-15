package LeetCodeHot100.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历，深度优先遍历和广度优先遍历
 */
public class TreeTraversal {

    /**
     * 使用递归遍历
     * 二叉树 深度优先遍历，根--左--右，其实就是二叉树的前序遍历
     */
    public void dfs(TreeNode treeNode) {
        //递归终止点
        if (treeNode == null) {
            return;
        }
        //根
        System.out.println(treeNode.val);
        //左
        dfs(treeNode.left);
        //右
        dfs(treeNode.right);
    }

    /**
     * 二叉树 深度优先遍历，根--左--右
     * 使用栈遍历,不会产生因递归导致的栈溢出问题
     */
    public void dfs1(TreeNode treeNode) {
        if (treeNode == null){
            return;
        }
        //声明栈
        Deque<TreeNode> stack = new LinkedList<>();
        //先把根节点压栈
        stack.push(treeNode);

        //遍历节点
        while (!stack.isEmpty()){
            //遍历根节点
            TreeNode node = stack.pop();
            System.out.println(node.val);
            //先进后出，先压右节点再压左节点
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
    }
    /**
     * 二叉树的广度优先遍历
     * 使用队列实现
     */
    public void bfs(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        //根节点入队列
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null){
                queue.offer(treeNode.right);
            }
        }
    }
}
