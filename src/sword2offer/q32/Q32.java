package sword2offer.q32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author starry
 *
 * 一，从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 二，请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 *
 */
public class Q32 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)return res;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()){
            TreeNode node = que.pollFirst();
            res.add(node.val);
            if (node.left != null)que.add(node.left);
            if (node.right != null)que.add(node.right);
        }
        return res;

    }

    /**
     * 之字形打印二叉树
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if (root == null)return res;

        LinkedList<TreeNode> que = new LinkedList<>();
        int thisLayer = 1;
        int nextLayer = 0;
        boolean reverse = false;
        que.add(root);
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        while (!que.isEmpty()){

            TreeNode node = que.pollFirst();
            tmp.add(node.val);
            if (node.left != null){
                que.add(node.left);
                nextLayer ++;
            }
            if (node.right != null){
                que.add(node.right);
                nextLayer ++;
            }

            thisLayer -- ;
            if (thisLayer == 0){
                ArrayList<Integer> layer = new ArrayList<>();
                if (!reverse){
                    while (!tmp.isEmpty()){
                        layer.add(tmp.pollFirst());
                    }
                }

                else while (!tmp.isEmpty()){
                    layer.add(tmp.pollLast());
                }
                res.add(layer);
                reverse = !reverse;
                tmp.clear();
                thisLayer = nextLayer;
                nextLayer = 0;
            }
        }
        return res;
    }

}
