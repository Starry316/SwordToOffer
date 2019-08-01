package sword2offer.q38;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author starry
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路： 每次调用递归方法，依次固定一个起始字符，然后将剩下的进行全排列
 */
public class Q38 {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0)
            return res;
        PermutationCore(res,str,0);
        // 字典序需要排序
        Collections.sort(res);
        return res;
    }
    public void PermutationCore(ArrayList<String> res ,String str, int startIndex){
        if (startIndex == str.length()) {
            //如果有重复字符，这里用来去重复
            if (res.contains(str))return;
            res.add(str);
        }
        else {
            for (int i = startIndex; i < str.length(); i++) {
                str = swapStr(str,startIndex,i);
                PermutationCore(res,str,startIndex+1);
                str = swapStr(str,i,startIndex);
            }
        }
    }
    public String swapStr(String str,int i,int j){
        StringBuffer s = new StringBuffer(str);
        char t = s.charAt(i);
        s.setCharAt(i,s.charAt(j));

        s.setCharAt(j,t);
        return s.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> res = new Q38().Permutation("abc");
        for (String i :res)System.out.println(i);
    }
}
