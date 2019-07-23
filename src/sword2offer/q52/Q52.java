package sword2offer.q52;

/**
 * @Author starry
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 思路
 *  首先获取到两个链表的长度差，快慢指针找到相同节点就可以
 */
public class Q52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)return null;
        int len1 = 0;
        int len2 = 0;
        ListNode tmp = pHead1;
        while (tmp !=null){
            len1++;
            tmp = tmp.next;
        }
        tmp = pHead2;
        while (tmp !=null){
            len2++;
            tmp = tmp.next;
        }
        tmp = pHead1;
        ListNode tmp2 = pHead2;
        while (len1>len2){
            len1 --;
            tmp = tmp.next;
        }
        while (len2>len1){
            len2--;
            tmp2 = tmp2.next;
        }

        while (tmp != null&&tmp2!=null&&tmp!=tmp2){
            tmp = tmp.next;tmp2 = tmp2.next;
        }
        return tmp;

    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
