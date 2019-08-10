package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 */
public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        combinationSum3Core(k,n,0,new LinkedList<Integer>(),res);
        return res;
    }
    public void combinationSum3Core(int k, int n, int num, LinkedList<Integer> list, List<List<Integer>> res){
        if (k == 0){
            if (n == 0)res.add((List<Integer>) list.clone());
        }
        else {
            if (n>0){
                for (int i = num+1; i <= 9 ; i++) {
                    list.add(i);
                    combinationSum3Core(k-1, n-i,i, list,res);
                    list.removeLast();
                }
            }
            else return;
        }
    }

    public static void main(String[] args) {
        byte allocation1[] = new byte[30900*1024];
        byte allocation2[] = new byte[18900*1024];

        ClassLoader loader = Q216.class.getClassLoader();	//获得加载ClassLoaderTest.class这个类的类加载器
        while(loader != null) {
            System.out.println(loader);
            loader = loader.getParent();	//获得父类加载器的引用
        }
        System.out.println(loader);

        new Q216().combinationSum3(3,7);
    }
}
