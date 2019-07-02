package leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q20 {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        char str[] = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (this.isLeft(str[i])){
                stack.push(str[i]);
            }
            else {
                if (stack.isEmpty()||!this.isRight(stack.peek(),str[i]))return false;
                else stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
    public boolean isLeft(char c){
        if (c == '('||c=='{'||c=='[')return true;
        return false;
    }
    public boolean isRight(char l,char r){
        if (l == '(' && r == ')')return true;
        if (l == '{' && r == '}')return true;
        if (l == '[' && r == ']')return true;
        return false;
    }
}
