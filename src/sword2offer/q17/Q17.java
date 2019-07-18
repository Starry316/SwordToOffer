package sword2offer.q17;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 *
 * 输入n 打印 1到n位最大的十进制数
 *
 * 思路： 全排列，递归输出结果
 */
public class Q17 {

    public void printMaxN(int n){
        char[] res = new char[n];
        // 最高位的开头 从 0 - 9
        for (int i = 0; i < 10; i++) {
            res[0] = (char)('0'+i);
            printMaxNRecursively(res,n,1);
        }

    }

    public void printMaxNRecursively(char []res, int n,int index){
        if (index == n){
//            for (int i = 0; i < res.length; i++) {
//                System.out.print(res[i]+" ");
//            }
//
//            System.out.println();
            printNumber(res);
            return;
        }

        for (int i = 0; i < 10; i++) {
            res[index] = (char)('0'+i);
            printMaxNRecursively(res, n, index+1);
        }
    }

    public void printNumber(char []num){
        boolean beginningWithZero = true;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != '0')beginningWithZero = false;
            if (!beginningWithZero || i == num.length-1)System.out.print(num[i]+" ");
        }
        System.out.println();
    }




    public static void main(String []args){

        int [] in = {1,2,3,4,5,6,7};

        new Q17().printMaxN(3);
    }
}
