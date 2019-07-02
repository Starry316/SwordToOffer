package sword2offer.q10;

/**
 * @Author starry
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 * 思路：递归方法效率较低，出现多次重复计算。那么需要缓存中间结果即可
 */
public class Q10 {
    public int Fibonacci(int n) {
        int f1 = 0;
        int f2 = 1;
        int f = 1;
        if(n == 0)return 0;
        if(n == 1)return 1;
        for(int i = 1;i<n;i++){
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
