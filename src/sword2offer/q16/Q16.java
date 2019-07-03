package sword2offer.q16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 思路：
 * 简单快速幂
 * 如果求得了 base^n/2，那么base^n = base^n/2 * base^n/2
 * 可以把时间复杂度优化到 logn
 *
 * 还需要考虑负数，为0等情况
 */
public class Q16 {
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        double res = Power(base, exponent>>1);
        res*=res;
        if ((exponent & 0x1) == 1)res*=base;
        return res;
     }
}
