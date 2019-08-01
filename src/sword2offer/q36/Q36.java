package sword2offer.q36;


import sun.reflect.generics.tree.Tree;

/**
 * @Author starry
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路：
 * 中序遍历，并记录前驱节点。
 */
public class Q36 {
    TreeNode pre = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;

        ConvertCore(pRootOfTree);
        TreeNode res = pRootOfTree;
        while (res.left!=null){
            System.out.println(res.val);
            res = res.left;
        }
        return res;
    }

    public void ConvertCore(TreeNode root) {

        if (root == null)return;
        ConvertCore(root.left);
        // 这里感觉不好理解呢
        // 重点在这里，左子树遍历结束后，pre指向的是左子树最右边的节点
        root.left = pre;
        if (pre != null)
            pre.right = root;

        // 给pre赋值
        pre = root;

        ConvertCore(root.right);
    }
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);

        a3.left = a2;
        a2.left = a1;
        a3.right = a4;
        a4.right = a5;

        TreeNode s = new Q36().Convert(a3);

    }


    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
