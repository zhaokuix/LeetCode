package LeetCodeHot100;

import LeetCodeHot100.common.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 二叉树的序列化与反序列化
 * 层序遍历
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        List<String> ans = new ArrayList<>();
        //层序遍历序列化二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode node = queue.poll();
                if (node == null){
                    ans.add("null");
                }else {
                    ans.add(String.valueOf(node.val));
                }
                if (node != null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        int index = 0;
        for (int i = ans.size() - 1; i >= 0; i--) {
            if (!Objects.equals(ans.get(i), "null")){
                index = i;
                break;
            }
        }
        StringJoiner joiner = new StringJoiner(",");
        for (int i = 0; i <= index; i++) {
            joiner.add(ans.get(i));
        }
        return joiner.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null){
            return null;
        }
        String[] split = data.split(",");
        if (split.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < split.length){
            TreeNode node = queue.poll();
            if (Objects.equals(split[i], "null")){
                node.left = null;
            }else {
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            if (i + 1 >= split.length){
                break;
            }
            if (Objects.equals(split[i + 1], "null")){
                node.right = null;
            }else {
                node.right = new TreeNode(Integer.parseInt(split[i + 1]));
                queue.add(node.right);
            }
            i = i + 2;
        }
        return root;
    }

    public static void main(String[] args) {
        String s = "1,2,3,4";
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(s);
        System.out.println(ser.serialize(ans));
    }
}
