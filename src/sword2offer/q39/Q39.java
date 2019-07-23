package sword2offer.q39;

/**
 * @Author starry
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 思路：
 *  1. 使用快排思想，找出中位数
 *  2. 由于相同数字超过一半，也就是该数字比其他数字加起来都多。可以考虑记录遇到的数字出现的次数
 *  如果是相同的数字，计数+1，否则-1，为0时替换，最后剩下的肯定是目标数字
 */
public class Q39 {
    public int MoreThanHalfNum_Solution(int [] array) {
        return 0;
    }

    public int MoreThanHalfNum_Solution_2(int[] array){
        if (array.length == 0) return 0;
        int count = 1;
        int markNum = array[0];
        for (int i = 1; i < array.length; i++) {

            if (markNum == array[i])count++;
            else count--;
            if (count == 0) {
                markNum = array[i];
                count ++;
            }
        }

        // 用于判断是否真的超过一半
        count = 0;
        for (int i = 0; i < array.length; i++) {

            if (markNum == array[i])count++;

        }
        if (count*2<array.length)return 0;

        return markNum;
    }
}
