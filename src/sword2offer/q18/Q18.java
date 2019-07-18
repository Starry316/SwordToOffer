package sword2offer.q18;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @Author starry
 * 一. 在O（1）时间内删除链表节点
 *    给定链表头指针和节点指针，在O（1）的时间内删除该节点
 *
 * 思路：
 * O（n）：常规做法是从头节点开始，获取到目标节点的前驱，才可以删除目标节点
 * O（1）：将目标节点的后继节点内容复制到目标节点上，再删除后继节点。需要考虑目标节点的后继是否为空，
 * 如果为空，那么也只能从头节点开始遍历到目标节点。平均时间复杂度仍是O（1）
 *
 * 二. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 思路：
 * 为方便遍历，建立一个虚拟的新的头节点pNewHead next为pHead。剩下的就是删除重复节点。
 * 最后返回pNewHead.next 即可
 *
 *
 */

public class Q18 {
    /**
     * 题目一
     * @param pHead
     * @param pNodeToBeDelete
     */
    public void deleteNode(ListNode pHead, ListNode pNodeToBeDelete){
        // 后继节点非空
        if (pNodeToBeDelete.next != null){
            pNodeToBeDelete.val = pNodeToBeDelete.next.val;
            pNodeToBeDelete.next = pNodeToBeDelete.next.next;
        }
        else {
            ListNode before = pHead;
            ListNode current = pHead;
            while (current != pNodeToBeDelete || current != null){
                before = current;
                current = current.next;
            }
            if (current == pNodeToBeDelete)
                before.next = null;
        }

    }

    /**
     * 题目二
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pCur = pHead;
        ListNode pNewHead = new ListNode(0);
        ListNode pPre = pNewHead;
        pPre.next = pHead;
        while (pCur != null){
            // 如果下个节点是null，说明遍历到了尾部
            if (pCur.next == null)break;
            // 寻找下一个不重复的节点，没有重复返回当前节点
            ListNode nextFind = findDifferentNode(pCur);
            // 当前节点没有重复
            if (nextFind != null && nextFind.val == pCur.val) {
                pPre = pCur;
                pCur = pCur.next;
            }
            // 如果找的节点不是原节点
            else {
                pCur = nextFind;
                pPre.next = pCur;
            }
        }
        return pNewHead.next;

    }

    /**
     * 若当前节点重复返回下一个节点，
     * 若当前节点不重复，返回自身
     * @param pNode
     * @return
     */
    public ListNode findDifferentNode(ListNode pNode){
        if (pNode.next == null||pNode.next.val != pNode.val)return pNode;
        else {
            ListNode pCur = pNode.next;
            while (pCur != null){
                if (pCur.val != pNode.val)
                    return pCur;
                pCur = pCur.next;
            }
            return null;
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
