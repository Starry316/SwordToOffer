package leetcode;

/**
 * @Author starry
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 思路：
 * 遍历中心点，从中心点向两边拓展
 *  1 2 3 2 1
 *  .          res = 1
 *  1 2 3 2 1
 *    .        res = 2
 *  1 2 3 2 1
 *      .
 *  1 2 3 2 1
 *    . . .
 *  1 2 3 2 1
 *  . . . . . res = 7
 *
 *  ......
 */
public class Q647 {
    public int countSubstrings(String s) {
        if (s.length() == 0)return 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            //以当前点i位置，向两边扩展,以i i+1位置向两边扩展
            res += countSegment(s, i, i);
            res += countSegment(s, i, i + 1);
        }
        return res;
    }


    public int countSegment(String s, int left, int right) {
        int count = 0;
        // 从中心向外拓展
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        new Q647().countSubstrings("aaa");
    }
}
