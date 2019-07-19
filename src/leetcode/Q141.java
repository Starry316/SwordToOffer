package leetcode;

/**
 * @Author starry
 * 环形链表
 * 简化版剑指offer23题 只需要判断是否有环
 */
public class Q141 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null)return false;
        ListNode pSlow = head;
        ListNode pFast = head.next;
        while (pFast != null && pSlow != pFast){
            pFast = pFast.next;
            pSlow = pSlow.next;
            if (pFast != null)pFast = pFast.next;
        }
        if (pFast == null) return false;
        return true;
    }
}
