package sword2offer.q12;

/**
 * @Author starry
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 思路：
 *  简单的DFS即可
 *
 * 遇到的坑：
 *  通过rowPos和colPos计算matrix对应元素时
 *  应该是rowPos * cols + colPos
 */
public class Q12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        boolean mark[][] = new boolean[rows][cols];
        if (str.length == 0)return true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i*cols+j] == str[0]){
                    mark[i][j] = true;
                    if (this.dfs(matrix,i,j,rows,cols,str,1,mark))return true;
                    else mark[i][j] = false;
                }
            }
        }
        return false;

    }
    public boolean dfs(char[] matrix,int rowPos,int colPos, int rows, int cols, char[] str,int step,boolean mark[][]){

        if (step == str.length)return true;
        // 四个方向
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        // 标记当前位置走过
        mark[rowPos][colPos] = true;
        for (int i= 0;i<4;i++){
            // 位置是否越界
            if ((rowPos+dir[i][0] < rows )&& (rowPos+dir[i][0] >=0)&&
                    (colPos+dir[i][1] < cols )&& (colPos+dir[i][1] >=0)){
                // 位置是否走过
                if (!mark[rowPos+dir[i][0]][colPos+dir[i][1]]){
                    // 位置元素是否是下个目标
                    if (matrix[(rowPos+dir[i][0])*cols+colPos+dir[i][1]] == str[step]){
                        if (dfs(matrix,rowPos+dir[i][0],colPos+dir[i][1],rows,cols,str,step+1,mark))
                            return true;
                        else continue;
                    }

                }
            }
        }
        // 回溯
        mark[rowPos][colPos] = false;
        return false;
    }
    public static void main(String []args){

        int [] in = {1,1,1,0,1,1,1};
        char[] matrix={'a','b','c','e',
                        's','f','c','s',
                        'a','d','e','e'};
        char[]str = {'a','s','c','c','e','d'};
        new Q12().hasPath(matrix, 3, 4,str);
    }
}
