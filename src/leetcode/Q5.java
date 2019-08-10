package leetcode;

/**
 * @Author starry
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 思路
 * manacher算法 O（n）时间复杂度
 */
public class Q5 {
    public String longestPalindrome(String s) {
        if (s==null || s.length() <= 1)return s;
        String t = preProcess(s);
        int p [] = new int[t.length()];
        int maxR = 0;
        int maxRsCenter = 0;
        for (int i = 1; i < t.length()-1; i++) {
            // 如果 i < maxR，p[i] 为与当前maxRsCenter对称的值。 如果p[i]超过当前边界R，赋值为maxR - i
            p[i] = maxR > i ? Math.min(p[2 * maxRsCenter -i], maxR - i):0;
            // 向两边拓展更新
            while (t.charAt(i+p[i]+1) == t.charAt(i-p[i]-1))
                p[i]++;
            // 更新新的maxR
            if (p[i] + i > maxR){
                maxR = p[i] + i;
                maxRsCenter = i;
            }
        }

        // 找出最大的回文子串
        int c = 0;
        int r = 0;
        for (int i = 0; i < t.length(); i++) {
            if (r < p[i]){
                c = i;
                r = p[i];
            }
        }
        int left =(c - r) >> 1;
        return s.substring(left,left+r);
    }

    /**
     * manacher 算法预处理
     * 将字符串abc处理成 ^#a#b#c#$ 形式
     * @param s
     * @return
     */

    public String preProcess(String s) {
        if (s.length() == 0)return "^$";
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++)
            sb.append("#" + s.charAt(i));
        sb.append("#$");
        return sb.toString();
    }







    public static void main(String[] args) {
        new Q5().longestPalindrome("abb");
    }
}
