package leetcode;

import sword2offer.q17.Q17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Q46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        permuteRecursively(res, nums, 0);

        return res;
    }
    public void permuteRecursively(List<List<Integer>>res,int nums[], int index){
        if (index == nums.length-1){
            ArrayList<Integer> item = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                item.add(nums[i]);
            }
            res.add(item);
            return;
        }
        else {
            for (int i = index; i < nums.length; i++) {
                swap(nums,i,index);
                permuteRecursively(res,nums,index+1);
                swap(nums,i,index);
            }
        }
    }
    public void swap(int nums[], int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
