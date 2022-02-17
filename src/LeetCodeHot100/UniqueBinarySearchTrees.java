package LeetCodeHot100;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    /**
     * 不同的二叉搜索树
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     * 输入：n = 3
     * 输出：5
     * 设 n能生成的二叉搜索树的个数为G(n)。
     * 对于i,(1 <= i <= n)它的左子树能形成的二叉搜索树的个数为：G(i-1)，右子树能形成的二叉搜索树的个数为G(n-i)
     * 那么对于i来说他能生成的二叉搜索树的个数为：左子树的个数乘以右子树的个数。即：
     * F(i,n) = G(i-1) * G(n-i),F(i,n)表示以i为根节点时,节点数为n时能生成的二叉搜索树的个数。
     * 那么：G(n) = F(1,n) + F(2,n) + ... +F(n,n)
     *
     * 因此可以使用动态规划的方法来解决此问题
     *
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
