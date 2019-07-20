package leetcode;

/**
 * @Author starry
 *
 * 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 */
public class Q61 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null;
        int count = 0;
        ListNode cur = head;
        while (cur!=null){
            count++;
            cur = cur.next;
        }
        k = k % count;
        cur = head;
        ListNode newHead = head;
        for (int i = 0; i < count-k-1; i++) {
            cur = newHead;
            newHead = newHead.next;
        }
        cur.next = null;
        if (newHead == null)return head;
        cur = newHead;
        while (cur.next!=null){
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }
}
