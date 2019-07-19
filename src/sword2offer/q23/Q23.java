package sword2offer.q23;

import javax.swing.tree.TreeNode;

/**
 * @Author starry
 *
 * 如果一个链表中包含环，如何找出环的入口节点。
 *
 * 思路：
 * 首先需要确定链表中是否有环，方法是通过一快一慢两个指针，如果快指针和慢指针相遇，说明出现了环
 * 再记录两个指针相遇的节点，从该处遍历并记数，当指针回到该节点时，计数count就是环的大小。
 * 再使用两个指针，其中一个指针比另一个快count步，相遇的节点就是入口节点
 */
public class Q23 {
    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode findEntryNode(ListNode head){
        if (head == null) return null;
        ListNode meetNode = findMeetNode(head);
        if (meetNode == null)return null;

        int circleCount = findCircleLength(meetNode);

        ListNode pFast = head;
        ListNode pSlow = head;
        for (int i = 0; i < circleCount; i++)
            pFast = pFast.next;

        while (pFast != pSlow){
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
    }
    public int findCircleLength(ListNode flag){
        ListNode cur = flag.next;
        int count = 1;
        while (cur != flag){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ListNode findMeetNode(ListNode head){
        if (head == null)return null;
        ListNode pSlow = head;
        ListNode pFast = head.next;

        while (pFast != null && pSlow != pFast){

            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) pFast = pFast.next;
        }
        return pFast;
    }
    public static void main(String []args){

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a3;
        new Q23().findEntryNode(a1);
    }
}
