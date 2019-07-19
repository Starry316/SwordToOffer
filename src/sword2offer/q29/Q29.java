package sword2offer.q29;

import java.util.ArrayList;

/**
 * @Author starry
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Q29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
//    public void printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rows = matrix[0].length;
        int cols = matrix.length;
        for (int i = 0; i < Math.min(rows-1,cols-1)/2+1; i++) {
            for (int j = i; j < rows-i; j++) {
                res.add(matrix[i][j]);
            }

            for (int j = i+1; j < cols-i; j++) {
                res.add(matrix[j][rows-1-i]);
            }

            if (cols-i-1!=i)
            for (int j = rows-i-2; j >= i; j--) {
                res.add(matrix[cols-i-1][j]);
            }

            if (rows-i-1!=i)
            for (int j = cols-i-2; j > i; j--) {
                res.add(matrix[j][i]);
            }

        }
        return res;
    }
    public static void main(String []args){

        System.out.println(2%5);
    }
}
