package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    /**
     * 最大路径和
     *
     * 对于树的题目，有统一的思考方法，那就是站在树（子树）的顶端根节点root思考。
     * 那么对于此题，我们思考如下问题：如果当前处在root节点，左右节点应该告诉我们什么信息才能得到答案？
     *
     * 根据题中对路径的定义，对于此题我们来回答以上问题。当我们遍历到树中某个节点时，我希望左子节点告诉我，在左子树中，以左子节点为开始（端点）的路径和最大为多少，
     * 同理我也希望右子节点告诉我类似的信息。
     *
     * 如果有了以上信息，再来思考最后一个问题：有了这个信息如何得到答案？
     *
     * 显然，对于当前节点有四个选择：
     *
     * 我自己就是一条路径
     * 只跟左子节点合并成一条路径
     * 只跟右子节点合并成一条路径
     * 以自己为桥梁，跟左、右子节点合并成一条路径
     * 需要注意的是，我们在递归求解的时候，第四种情况是不能作为递归的返回值的，因为它不符合我们对递归所期望返回值的定义
     * （因为此时该子节点并不是拥有最大路径和路径的起点（端点）），
     * 但它也是一个可能的解，所以我们用一个全局变量记录上面四种值的最大值，递归结束后，该变量就是答案。
     *
     * 再次强调一下，当节点以自己为桥梁连接两边形成一条路径时，根据路径定义，
     * 其祖先节点不再可能加入到这条路径中，也就是说这种情况下，它是解的一种可能，但不符合我们递归返回值的定义。

     */
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        /*
         * 我自己就是一条路径
         * 只跟左子节点合并成一条路径
         * 只跟右子节点合并成一条路径
         * 在这三种情况中求出最大值
         */
        int currentMax = Math.max(root.val, root.val + Math.max(left, right));

        /*
         * 以自己为桥梁，跟左、右子节点合并成一条路径
         * 第四种情况
         */
        int fourCase = root.val + left + right;

        //求四种情况的最大值
        ans = Math.max(ans,Math.max(fourCase, currentMax));
        return currentMax;
    }
}
