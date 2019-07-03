package sword2offer.q13;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author starry
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 思路 ：
 *  BFS 并记录走过的点个数即可
 *
 * 遇到的坑：
 *  输入rows cols小于等于0
 *  threshold小于0 （即初始点也不能到达）
 */
public class Q13 {
    public int movingCount(int threshold, int rows, int cols){
        if (rows<=0 || cols<=0)return 0;
        boolean visited [][] = new boolean[rows][cols];
        int count = 0;
        visited[0][0] = true;

        Queue<Pos> que = new LinkedBlockingQueue<Pos>();
        if (this.checkCanMove(0,0,threshold))
            que.add(new Pos(0,0));

        // 四个方向
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!que.isEmpty()){
            count++;
            Pos now = que.poll();
            for (int i = 0; i < 4; i++) {
                int x = now.x + dir[i][1];
                int y = now.y + dir[i][0];
                if ((x >= 0 && x < rows) && (y >=0 && y < cols)){
                    if (!visited[x][y] && this.checkCanMove(x, y, threshold)){
                        que.add(new Pos(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
        return count;
    }
    private class Pos{
        public int x,y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean checkCanMove(int x, int y, int target){
        if (this.digitSum(x)+this.digitSum(y) > target)return false;
        return true;
    }

    /**
     * 计算十进制的每一位相加和
     * @param s
     * @return
     */
    private int digitSum(int s){
        int sum = 0;
        while (s > 0){
            sum += s%10;
            s/=10;
        }
        return sum;
    }
}
