package sword2offer.q6;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author starry
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 思路一 使用栈实现倒序
 * 思路二 递归实现
 */
public class Q6 {
    /**
     * 栈实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = listNode;
        while (node!=null){
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty())
            res.add(stack.pop());
        return res;
    }

    /**
     * 递归实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadRec(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (listNode != null)
            this.recToListEnd(res, listNode);
        return res;
    }
    public void recToListEnd(ArrayList<Integer> list, ListNode listNode){
        if (listNode.next == null) list.add(listNode.val);
        else {
            recToListEnd(list, listNode.next);
            list.add(listNode.val);
        }
    }

    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
}
