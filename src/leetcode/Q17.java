package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 思路：
 * 类似全排列，比较简单
 */
public class Q17 {
    private static final String[] chars= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() == 0)return res;
        doCombination(digits,"",res);
        return res;
    }
    public void doCombination(String digits, String t, List<String> res){
        if (digits.length() == 1){
            for (int i = 0; i < chars[Integer.parseInt(digits)].length(); i++) {
                res.add(t+chars[Integer.parseInt(digits)].charAt(i));
            }
            return ;
        }
        else {
            for (int i = 0; i < chars[Integer.parseInt(digits.charAt(0)+"")].length(); i++) {
                doCombination(digits.substring(1),t+chars[Integer.parseInt(digits.charAt(0)+"")].charAt(i),res);
            }
        }
    }
}
