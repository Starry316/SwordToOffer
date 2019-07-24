package sword2offer.q54;

import java.util.LinkedList;

/**
 * @Author starry
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * 思路：
 *  中序遍历二叉搜索树就是排序的序列
 */
public class Q54 {
    int k;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0)return null;
        this.k = k;
        return doKthNode(pRoot);
    }

    TreeNode doKthNode(TreeNode root){
        TreeNode res = null;
        // 左子树
        if (root.left!=null)
            res = doKthNode(root.left);
        // 左子树没有找到
        if (res == null){
            k--;
            if (k == 0)
                return root;
            // 右子树
            if (root.right !=null){
                return doKthNode(root.right);
            }
        }
        return res;

    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
