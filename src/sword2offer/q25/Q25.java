package sword2offer.q25;

/**
 * @Author starry
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路：
 * 1. 循环，两个指针记录两个链表的位置，比较指针头的节点值。判断条件较多。
 * 2. 递归，每次选出较小的一个节点，递归传入该节点后一个节点和另一个链表。
 *
 */
public class Q25 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        return MergeCore(list1,list2);
    }
    public ListNode MergeCore(ListNode list1, ListNode list2){
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        if (list1.val < list2.val){
            list1.next = MergeCore(list1.next, list2);
            return list1;
        }
        else {
            list2.next = MergeCore(list1, list2.next);
            return list2;
        }
    }


//    ListNode p1 = list1;
//    ListNode p2 = list2;
//    ListNode fp1 = p1;
//        if(p1 == null) return p2;
//        if(p2 == null) return p1;
//        while(p1 != null){
//        if(p2 == null){
//            break;
//        }
//        if(p1.val<=p2.val){
//            fp1 = p1;
//            p1 = p1.next;
//
//        }
//        else if(p1.val>p2.val){
//            ListNode p2n = p2.next;
//            fp1.next = p2;
//            p2.next = p1;
//            fp1 = p2;
//
//            p2 = p2n;
//        }
//    }
//        if(p2 != null){
//        fp1.next = p2;
//    }
//        return list1;
//}


}
