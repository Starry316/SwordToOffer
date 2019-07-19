package sword2offer.q27;

/**
 * @Author starry
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 思路：对调每个节点的左右子树即可
 */
public class Q27 {
    public void Mirror(TreeNode root) {
        if (root == null)return;
        MirrorCore(root);
    }
    public void MirrorCore(TreeNode root){
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.right != null)MirrorCore(root.right);
        if (root.left != null)MirrorCore(root.left);
    }



//    public void Mirror(TreeNode root) {
//        if(root == null || (root.left == null && root.right == null))
//            return;
//
//        if(root.left != null){
//            Mirror(root.left);
//        }
//        if(root.right !=null){
//            Mirror(root.right);
//        }
//        this.swap(root);
//
//
//
//    }
//    public static void swap(TreeNode a){
//        TreeNode tmp = a.left;
//        a.left = a.right;
//        a.right = tmp;
//    }

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
