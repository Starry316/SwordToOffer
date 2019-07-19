package sword2offer.q26;

import java.util.LinkedList;

/**
 * @Author starry
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 思路：
 * 首先寻找到A树中与B树根节点值相同的节点，然后再判断是否有相同的结构
 */
public class Q26 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null)return false;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root1);
        // 层次遍历
        while (!que.isEmpty()){
            TreeNode treeNode = que.pollFirst();
            if (treeNode.val == root2.val){
                if (checkSubtree(treeNode, root2))return true;
            }
            if (treeNode.left != null)
                que.add(treeNode.left);
            if (treeNode.right != null)
                que.add(treeNode.right);
        }
        return false;
    }
    public boolean checkSubtree(TreeNode root1, TreeNode root2){
        if (root1 == null)return false;
        if (root1.val == root2.val){
            boolean res = true;
            if (root2.left != null)
                res = res && checkSubtree(root1.left, root2.left);
            if (root2.right != null)
                res = res && checkSubtree(root1.right, root2.right);
            return res;
        }
        return false;
    }
}
