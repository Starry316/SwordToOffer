package sword2offer.q28;

/**
 * @Author starry
 * 对称的二叉树
 *
 * 思路：比较前序遍历序列和对称的前序遍历序列是否相同即可，注意判断条件
 */
public class Q28 {
     private class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)return true;
        return isSymmetricCore(root.left,root.right);
    }
    public boolean isSymmetricCore(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)return false;
        return isSymmetricCore(root1.left,root2.right)&&isSymmetricCore(root1.right,root2.left);
    }
}
