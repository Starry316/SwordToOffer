package leetcode;

import java.util.Stack;

/**
 * @Author starry
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 思路：
 * 1. 使用栈
 * 与找到每个可能的子字符串后再判断它的有效性不同，我们可以用栈在遍历给定字符串的过程中去判断到目前为止扫描的子字符串的有效性，同时能的都最长有效字符串的长度。我们首先将 -1−1 放入栈顶。
 *
 * 对于遇到的每个 ‘(’  ，我们将它的下标放入栈中。
 * 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，得出当前有效括号字符串的长度。通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
 * 时间O（n） 空间O（n）
 *
 * 2. 使用两个计数器，一个记录左括号数，一个记录右括号数，当左括号大于右括号时，向后遍历，右括号大于左括号时，即记录一次有效括号长度
 * 时间O（n） 空间O（1）
 */

public class Q32 {
    public int longestValidParentheses(String s) {
        int res = 0;
        if (s.length() == 0)return res;
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                leftCount++;
            }
            else {
                rightCount++;
                if (rightCount > leftCount){
                    res = Math.max(leftCount*2,res);
                    rightCount = 0;
                    leftCount = 0;
                }
                else {
                    res = Math.max(rightCount*2,res);
                }
            }
        }
        return res;
    }
    public int longestValidParentheses_stack(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }



    public int longestValidParentheses_dp(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


}
