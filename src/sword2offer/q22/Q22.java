package sword2offer.q22;

/**
 * @Author starry
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路：维护两个指针pEnd，pRes，首先使pEnd指针所指向的节点位置和头节点的距离为k，
 * 如果链表长度小于k，返回null
 * 之后令pRes = head，同步将pEnd和pRes向后遍历，当pRes遍历到链表最后一个节点时，
 * pRes指向的节点就是结果。
 */
public class Q22 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null)return null;
        ListNode pEnd = head;
        ListNode pRes = null;
        for (int i = 0; i < k; i++) {
            if (pEnd!=null)
                pEnd = pEnd.next;
            else return pRes;
        }
        pRes = head;
        while (pEnd!=null){
            pEnd = pEnd.next;
            pRes = pRes.next;
        }
        return pRes;

    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
