package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *

 */
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates.length == 0||target<=0)return res;
        doCombinationSum(candidates,0,target,res,new LinkedList<>());
        return res;
    }
    public void doCombinationSum(int [] candidates,int index, int target, List<List<Integer>> res, LinkedList<Integer> list){
        if (target == 0){
            res.add((List<Integer>) list.clone());
            return;
        }
        else if (target>0){
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                doCombinationSum(candidates,i,target-candidates[i],res,list);
                list.removeLast();
            }
        }
    }
}
