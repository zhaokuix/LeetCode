package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 路径总和 III
 */
public class PathSumIII {
    int pathNumber = 0;

    /**
     * 遍历每个节点，从每个节点出发寻找target
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        add(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return pathNumber;
    }
    public void add(TreeNode root, int targetSum){
        if (root == null){
            return;
        }
        targetSum -= root.val;
        if (targetSum == 0){
            pathNumber++;
        }
        add(root.left,targetSum);
        add(root.right, targetSum);
    }

}
