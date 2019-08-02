package leetcode;

/**
 * @Author starry
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 思路：
 *  中序遍历序列即是排序序列
 */
public class Q230 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return kthSmallestCore(root);
    }
    int k = 0;
    public int kthSmallestCore(TreeNode cur){
        int res = cur.val;
        // 访问左子树
        if (k != 0 && cur.left != null) res = kthSmallestCore(cur.left);
        // 访问自身
        if (k > 0){
            res  = cur.val;
            k--;
        }
        // 访问右子树
        if (k != 0 && cur.right != null) res = kthSmallestCore(cur.right);
        return res;
    }
}
