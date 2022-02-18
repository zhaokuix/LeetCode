package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreePreorderInorderTraversal {

    /**
     * 根据前序遍历和中序遍历构造二叉树
     * 1、前序遍历的第一个节点是根节点
     * 2、在中序遍历中找到根节点，根节点左边的数构成左子树，根节点右边的构成右子树
     * 左右子树分别递归地执行1和2。
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildMyTree(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }

    public TreeNode buildMyTree(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){

        if (preorderLeft > preorderRight){
            return null;
        }

        int rootVal = preorder[preorderLeft];
        //构建根节点
        TreeNode root = new TreeNode(rootVal);

        //找到中序遍历中根节点的位置(也可以初始化一个中序遍历的map简化此过程)
        int rootIndex = -1;
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        //那么左子树节点个数为
        int leftNodeCount = rootIndex - inorderLeft;
        //右子树个数为
        int rightNodeCount = inorderRight - rootIndex;

        root.left = buildMyTree(preorder,inorder,preorderLeft + 1,preorderLeft + leftNodeCount,inorderLeft,rootIndex - 1);
        root.right = buildMyTree(preorder,inorder,preorderRight - rightNodeCount + 1,preorderRight,rootIndex + 1,inorderRight);

        return root;
    }


}
