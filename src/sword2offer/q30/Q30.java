package sword2offer.q30;

import java.util.Stack;

/**
 * @Author starry
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：
 * 维护两个栈，一个是常规栈，另一个是最小值栈，如果push进来的数据小于最小栈顶元素，那么就将该数据push到最小栈顶
 * pop时，如果pop的数据和最小栈顶元素相同，同时pop最小栈。
 * 保证了最小栈栈顶记录的是当前栈中最小的元素
 */
public class Q30 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()||minStack.peek()>node){
            minStack.push(node);
        }
    }

    public void pop() {
        int v = stack.pop();
        if (!minStack.isEmpty()&&minStack.peek() == v) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
