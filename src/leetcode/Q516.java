package leetcode;

/**
 * @Author starry
 * 516. 最长回文子序列
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 思路
 * 求原字符串和其翻转的最长公共子序列即可
 */
public class Q516 {
    public int LCS(String s1, int n1, String s2, int n2) {
        // 递归
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        String _s = new StringBuffer(s).reverse().toString();
        return LCS(s, len , _s, len );
    }

}
