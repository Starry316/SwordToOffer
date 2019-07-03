package sword2offer.q15;

/**
 * @Author starry
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 思路：
 * 不能只简单地使用右移原数字进行判断，因为如果是补码表示的负数，会导致死循环
 * 做法一
 *  不对原数字进行右移，而是对flag进行左移，初始flag = 1 ，然后不断左移判断
 *  相当于每次都有一个只有一个1的二进制串与原数字进行判断 比如： 00001 00010 00100 01000 10000
 * 做法二
 *  一个不为0的数定然有至少一位是1 将其-1，则最右边的1变成0, 该位置之后的0变成1。
 *  例如 1100 - 1 = 1011
 *  与自身做与运算
 *  1100 & 1011 = 1000
 *  通过这样就消除了一个1，那么只需要1的个数次上述运算，就可以将原数字变成0
 */
public class Q15 {
    /**
     * 做法一
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        // int 是有符号数，所以移位完成后会为0
        while (flag!=0){
            if ((flag & n) != 0) count++;
            flag = flag << 1;
        }
        return count;
    }
    /**
     * 做法二
     * @param n
     * @return
     */
    public int NumberOf1Way2(int n) {
        int count = 0;
        while (n!=0){
            n = n &(n-1);
            count++;
        }
        return count;
    }
}
