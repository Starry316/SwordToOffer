package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 思路：
 * 一共要生成2n个括号，每次递归时需要满足未闭合的（ 的数量小于剩下未添加的符号数量，同时在（数量大于0时才可以添加）
 */
public class Q22 {
    public List<String> generateParenthesis(int n) {

        List<String> res = new LinkedList<>();
        if (n == 0)return res;
        doGenerateParenthesis(n*2,res,"",0);
        return res;
    }

    /**
     *
     * @param n 剩余待添加符号数
     * @param res 结果
     * @param t 缓存字符串
     * @param left 未闭合左括号
     */
    public void doGenerateParenthesis(int n, List<String> res, String t,int left){
        if (n == 0){
            res.add(t);
            return;
        }
        // 如果剩下待添加的符号数大于左括号数，那么可以继续添加（
        if (n>left)doGenerateParenthesis(n-1,res,t+"(",left+1);
        // 如果左括号数大于0，可以添加）
        if (left>0)doGenerateParenthesis(n-1,res,t+")",left-1);
    }
}
