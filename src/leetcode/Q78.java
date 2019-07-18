package leetcode;

import java.util.*;

/**
 * @Author starry
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 思路：位运算解法
 *
 */
public class Q78 {

    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int cur = label;

        int count = 1;
        int flag = 1;
        if (cur<flag){

        }
        flag = flag << 1;
        int a = 2^1;
        return null;
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();
        int bitNums = nums.length;
        int ansNums = 1 << bitNums; // 1 左移bitNums次，相当于求2^bitNums
        for (int i = 0; i < ansNums; i++) {
            List<Integer> tmp = new LinkedList<Integer>();
            int count = 0; //数组下标计数
            int n = i; //用来移位
            while (n!= 0) {
                if ((n & 1) == 1) { //判断当前位是否是 1
                    tmp.add(nums[count]);
                }
                count++;
                n = n >> 1;//右移一位
            }
            res.add(tmp);

        }
        return res;
    }

}
