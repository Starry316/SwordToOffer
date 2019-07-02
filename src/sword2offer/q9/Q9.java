package sword2offer.q9;

import java.util.Stack;

/**
 * @Author starry
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 *
 * 思路：使用A,B两个栈，入队元素push进A栈，出队时，如果B栈非空，就pop B栈元素，
 * 否则将A栈中所有元素加入B栈中，再进行出队。
 */
public class Q9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.isEmpty())
            return stack2.pop();
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.pop();
    }
}
