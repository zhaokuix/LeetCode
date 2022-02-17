package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    /**
     * 验证一棵二叉树是不是二叉搜索树，看中序遍历是否为升序即可
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        //存储中序遍历后的数据
        List<Integer> list = new ArrayList<>();
        //中序遍历 左-中-右
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()){
            while (root != null){
                deque.push(root);
                root = root.left;
            }
            TreeNode pop = deque.pop();
            list.add(pop.val);
            root = pop.right;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }
}
