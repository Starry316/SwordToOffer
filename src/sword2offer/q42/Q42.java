package sword2offer.q42;

/**
 * @Author starry
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 思路
 *  1. 使用dp dp[i] = {
 *     array[i] ,  if i = 0 or dp[i-1] <= 0
 *     array[i] + dp[i-1] ,  if i != 0 and dp[i-1] > 0
 *  }
 *  2. 遍及并记录子数列和sum，如果sum<=0 说明前面可以抛弃，重新计算。
 */
public class Q42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)return 0;
        int sum = 0;
        // 大负数
        int res = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (sum<=0)
                sum = 0;
            sum+=array[i];
            res = Math.max(res, sum);
        }
        return res;
    }
}
