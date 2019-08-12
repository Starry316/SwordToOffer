package leetcode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author starry
 * 103. 二叉树的锯齿形层次遍历
 */
public class Q103 {
    private class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;  TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int thisLayerSize = 1;
        int nextLayerSize = 0;
        boolean reverse = false;
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
                if (reverse)
                    Collections.reverse(thisLayer);
                res.add(thisLayer);
                reverse = !reverse;
                thisLayer = new LinkedList<>();
                thisLayerSize = nextLayerSize;
                nextLayerSize = 0;
            }
        }
        return res;
    }
}
