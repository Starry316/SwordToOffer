package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 102. 二叉树的层次遍历
 *
 * 记录当前层节点数和下层的节点数.
 */
public class Q102 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;  TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int thisLayerSize = 1;
        int nextLayerSize = 0;
        List<Integer> thisLayer = new LinkedList<>();
        while (!que.isEmpty()){
            TreeNode t = que.poll();
            thisLayer.add(t.val);
            thisLayerSize --;

            if (t.left != null){
                nextLayerSize++;
                que.offer(t.left);
            }
            if (t.right != null){
                que.offer(t.right);
                nextLayerSize++;
            }
            if (thisLayerSize == 0){
                res.add(thisLayer);
                thisLayer = new LinkedList<>();
                thisLayerSize = nextLayerSize;
                nextLayerSize = 0;
            }
        }
        return res;
    }
}
