package leetcode;

/**
 * @Author starry
 *  删除链表中的节点
 *
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 *
 * 把后一个节点复制给本节点就行。。。
 */
public class Q237 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        if (node.next == null)node=null;
        else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
