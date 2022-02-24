package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorBinaryTree {
    /**
     * 广度优先遍历，遍历一遍，记录节点的父节点组成数组
     * 遍历两个节点对应的父节点数组找到第一个公共父节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        //记录节点的父节点
        Map<TreeNode,TreeNode> childParentMap = new HashMap<>();

        //广度优先遍历
        bfs(root, childParentMap);

        //组装p和q----》root的父节点数组
        List<TreeNode> pList= new ArrayList<>();
        List<TreeNode> qList= new ArrayList<>();

        TreeNode point = p;
        pList.add(p);
        while (childParentMap.get(point) != null){
            TreeNode treeNode = childParentMap.get(point);
            pList.add(treeNode);
            point = treeNode;
        }
        point = q;
        qList.add(q);
        while (childParentMap.get(point) != null){
            TreeNode treeNode = childParentMap.get(point);
            qList.add(treeNode);
            point = treeNode;
        }
        //遍历数组找到最近的公共祖先
        for (TreeNode pNode : pList) {
            for (TreeNode qNode : qList) {
                if (pNode == qNode){
                    return pNode;
                }
            }
        }
        return null;
    }

    /**
     * 广度优先遍历，遍历一遍，记录节点的父节点
     * 用Set存储p的所有父节点，遍历q的父节点看是否存过了，找到第一个存过的就是最近的公共祖先
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        //记录节点的父节点
        Map<TreeNode,TreeNode> childParentMap = new HashMap<>();
        bfs(root, childParentMap);

        Set<TreeNode> set = new HashSet<>();
        TreeNode point = p;
        //p和p的父级们放入set中
        while (point != null){
            set.add(point);
            point = childParentMap.get(point);
        }
        //遍历q和q的父级们找到第一个相同的节点就是最近公共父级
        point = q;
        while (point != null){
            if (set.contains(point)){
                return point;
            }
            point = childParentMap.get(point);
        }
        return null;
    }
    public void bfs(TreeNode root, Map<TreeNode,TreeNode> childParentMap){
        //广度优先遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        childParentMap.put(root,null);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.add(node.left);
                childParentMap.put(node.left, node);
            }
            if (node.right != null){
                queue.add(node.right);
                childParentMap.put(node.right, node);
            }
        }
    }
}
