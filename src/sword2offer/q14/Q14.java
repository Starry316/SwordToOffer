package sword2offer.q14;

/**
 * @Author starry
 * 把长度为n的绳子剪成m段,n 和 m 都是整数, m > 1,每段绳子记作k[i]，k的最大可能乘积为多少？
 * 例如：n = 8 ， 2 3 3 得到最大值18
 *
 * 思路：动态规划
 * f (n) = max (f(i) * f(n-i))
 */
public class Q14 {
    public int maxMutiply(int n){
        int f[] = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for (int i = 4; i < n+1; i++)
            for (int j = 1; j <= i/2; j++)
                f[i] = Math.max(f[i-j]*f[j],f[i]);
        return f[n];
    }
    public static void main(String []args){

        System.out.println(new Q14().maxMutiply(8));
    }
}
