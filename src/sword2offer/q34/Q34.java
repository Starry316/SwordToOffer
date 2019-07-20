package sword2offer.q34;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author starry
 *
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Q34 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)return res;
        while (!que.isEmpty()){
            TreeNode node = que.pollFirst();
            ArrayList<Integer> t = new ArrayList<Integer>();
            dfs(res,t,target,node,0);
            if (node.left!=null)que.add(node.left);
            if (node.right!=null)que.add(node.right);
        }
//        for (ArrayList<Integer> i:res)
//            for (Integer J: i){
//                System.out.print(J+" ");
//            System.out.println();
//            }
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int target, TreeNode root,int step){
        if (target == root.val){
            if (root.right==null&& root.left == null){
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(step);
            }
            return;
        }
        if (target < root.val)return;

        path.add(root.val);

        if (root.left!=null){
            dfs(res,path,target-root.val,root.left,step+1);
        }
        if (root.right!=null){
            dfs(res,path,target-root.val,root.right,step+1);
        }
        path.remove(step);
    }
    public static void main(String args[]){
        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(12);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(7);

        a1.left =a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        new Q34().FindPath(a1,22);
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


