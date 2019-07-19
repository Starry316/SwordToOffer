package sword2offer.q25;

import java.util.Arrays;

/**
 * @Author starry
 */
public class MergeK {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)return null;
        return MergeCore(lists);
    }
    public ListNode MergeCore(ListNode[] lists){
        int [] vals = new int[lists.length];
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null){
                vals[i] = lists[i].val;
            }
            else vals[i] = 0x7fffffff;
        }
        int index = argSort(vals);

        ListNode node = lists[index];
        if (node == null)return null;
        lists[index] = lists[index].next;
        node.next = MergeCore(lists);
        return node;
    }
    public int argSort(int a[]){
        int min = 0x7fffffff;
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]<min){
                min = a[i];
                minIndex= i;
            }
        }
        return minIndex;
    }

}
