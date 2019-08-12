package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author starry
 * 144. 二叉树的前序遍历
 */
public class Q144 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;  TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode t = stack.pop();
            res.addLast(t.val);
            if (t.right!=null)
                stack.push(t.right);
            if (t.left!=null)
                stack.push(t.left);

        }
        return res;
    }
}
