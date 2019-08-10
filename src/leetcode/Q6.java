package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @Author starry
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 思路
 * 将每行看作一个字符串，按照z字形从上到下，从下到上反复填充
 */
public class Q6 {
    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows > s.length())
            return s;
        StringBuilder sb[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int sIndex = 0;
        while (sIndex<s.length()){
            for (int i = 0;i<numRows;i++){
                if (sIndex>=s.length())break;
                sb[i].append(s.charAt(sIndex++));
            }
            for (int i = numRows-2; i > 0; i--) {
                if (sIndex>=s.length())break;
                sb[i].append(s.charAt(sIndex++));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(sb[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Q6().convert("ABCDEFG",3);
    }
}
