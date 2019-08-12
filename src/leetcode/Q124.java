package leetcode;

/**
 * @Author starry
 * 124. 二叉树中的最大路径和 hard
 *
 */
public class Q124 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;  TreeNode(int x) { val = x; }
    }
    int maxSum =  -0x3f3f3f3f;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumCore(root);
        return maxSum;
    }
    public int maxPathSumCore(TreeNode cur){
        int leftSum = 0;
        int rightSum = 0;
        if (cur.left != null){
            leftSum = Math.max(maxPathSumCore(cur.left),0);
        }
        if (cur.right != null){
            rightSum = Math.max(maxPathSumCore(cur.right),0);
        }
        maxSum = Math.max(maxSum, cur.val+leftSum+rightSum);
        return cur.val+Math.max(leftSum,rightSum);
    }
}
