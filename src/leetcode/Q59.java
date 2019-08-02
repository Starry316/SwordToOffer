package leetcode;

/**
 * @Author starry
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Q59 {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];
        int num = 1;
        int circleCount = 0;
        while (circleCount <= n-circleCount-1){
            if (circleCount == n-circleCount-1)res[circleCount][circleCount] = num++;
            for (int i = circleCount; i < n-circleCount-1; i++) {
                res[circleCount][i] = num++;
            }
            for (int i = circleCount; i < n-circleCount-1; i++) {
                res[i][n-circleCount-1] = num++;
            }
            for (int i = n-circleCount-1; i > circleCount; i--) {
                res[n-circleCount-1][i] = num++;
            }
            for (int i = n-circleCount-1; i > circleCount ; i--) {
                res[i][circleCount] = num++;
            }
            circleCount++;
        }
        return res;
    }
}
