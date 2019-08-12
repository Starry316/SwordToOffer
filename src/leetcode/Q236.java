package leetcode;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @Author starry
 * 236. 二叉树的最近公共祖先
 *
 * 思路:
 *  1. 首先遍历二叉树,找到pq两个节点,并且记录遍历过程中每个节点的父节点.
 *  同时获取得到pq的深度,转换成求解链表的公共节点问题
 *
 *  2.
 */
public class Q236 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;  TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Hashtable<TreeNode, TreeNode> parent = new Hashtable<>();
        if (root == null) return root;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        boolean findQ = false;
        boolean findP = false;

        while (!que.isEmpty() && !(findP && findQ)){
            TreeNode treeNode = que.pollFirst();
            if (!findP && treeNode == p)findP = true;
            if (!findQ && treeNode == q)findQ = true;
            if (treeNode.left != null){
                parent.put(treeNode.left,treeNode);
                que.addLast(treeNode.left);
            }
            if (treeNode.right != null){
                parent.put(treeNode.right,treeNode);
                que.addLast(treeNode.right);
            }
        }
        int depthQ = 0;
        int depthP = 0;
        TreeNode t = q;
        while (t != null){
            t = parent.get(t);
            depthQ++;
        }
        t = p;
        while (t != null){
            t = parent.get(t);
            depthP++;
        }
        TreeNode pTmp = p;
        TreeNode qTmp = q;
        while (depthP > depthQ){
            pTmp = parent.get(pTmp);
            depthP --;
        }
        while (depthQ > depthP){
            qTmp = parent.get(qTmp);
            depthQ --;
        }

        while (qTmp != pTmp && qTmp!=null){
            qTmp = parent.get(qTmp);
            pTmp = parent.get(pTmp);
        }
        return qTmp;

    }
}
