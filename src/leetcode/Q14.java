package leetcode;

/**
 * @Author starry
 *
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)return "";
        String  res =strs[0];
        int pre = strs[0].length()-1;
        if (pre < 0)return "";
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j <= pre; j++) {
                if (strs[i].length() == j || strs[i].charAt(j) != res.charAt(j)) {
                    pre = j - 1;
                    break;
                }
            }
        }
        return pre==-1?"":res.substring(0,pre+1);
    }
}
