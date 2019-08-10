package leetcode;

import java.util.LinkedList;

/**
 * @Author starry
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 思路：
 * 1. BFS 超时
 * 2. 排列组合 实际上从左上角走到右下角向下和向右走的步数是确定的，所以根据公式计算c（m-1 m+n-2）即可
 *   但是很可能在阶乘的时候出现溢出
 * 3. dp dp[i][j] = dp[i-1][j] + dp[i][j-1]
 *
 */


public class Q62 {
    public static long factorial(long number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }
    public int uniquePaths(int m, int n) {
        if (m<=1||n<=1)return 0;
        return (int) (factorial((long)n+m-2)/(
                factorial((long)n-1)*
                factorial((long)m-1)));
    }

    /**
     * dp
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * bfs
     * @param m
     * @param n
     * @return
     */
    public int uniquePath_bfs(int m, int n) {
        LinkedList<Node> que = new LinkedList<>();
        if (m<1||n<1)return 0;
        que.addLast(new Node(0,0));
        int count = 0;
        while (!que.isEmpty()){
            Node node = que.pollFirst();
            if (node.x == m-1 && node.y == n-1)count++;
            if (node.x+1<m)que.addLast(new Node(node.x+1,node.y));
            if (node.y+1<n)que.addLast(new Node(node.x,node.y+1));
        }
        return count;
    }
    private class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(99));;
        new Q62().uniquePaths(2,100);
    }
}
