package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 实现 Trie (前缀树)
 */
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode point = root;
        for (char c : chars) {
            int index = c - 'a';
            if (point.nodes[index] == null){
                TrieNode node = new TrieNode();
                point.nodes[index] = node;
                point = node;
            }else {
                point = point.nodes[index];
            }
        }
        point.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode point = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (point.nodes[index] == null){
                return false;
            }
            point = point.nodes[index];
        }
        if (point.isEnd){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode point = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (point.nodes[index] == null){
                return false;
            }
            point = point.nodes[index];
        }
        return true;
    }

    class TrieNode{
        public boolean isEnd = false;
        public TrieNode[] nodes = new TrieNode[26];
    }
}
