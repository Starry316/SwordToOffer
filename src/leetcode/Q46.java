package leetcode;

import sword2offer.q17.Q17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> item = new ArrayList<>(nums.length);
            item.add(nums[i]);
            permuteRecursively(res, item, nums, 1);
        }
        return res;
    }
    public void permuteRecursively(List<List<Integer>>res, List<Integer> list,int nums[], int index){
        if (index == nums.length){
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.set(index, nums[i]);
            permuteRecursively(res, list, nums, index+1);
        }
    }


}
