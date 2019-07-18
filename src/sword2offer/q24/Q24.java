package sword2offer.q24;

/**
 * @Author starry
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * 思路：
 * 新链表头是原链表的尾部
 * 从头到尾，依次翻转就行
 */
public class Q24 {
    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode front = head;
        ListNode back = head.next;
        head.next = null;
        while(back != null){
            ListNode t = back.next;
            back.next = front;
            front = back;
            back = t;
        }
        return front;
    }
}
