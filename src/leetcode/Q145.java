package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author starry
 * 145. 二叉树的后序遍历
 *  迭代法
 */
public class Q145 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;  TreeNode(int x) { val = x; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null)return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if (treeNode.left!=null) stack.push(treeNode.left);
            if (treeNode.right!=null) stack.push(treeNode.right);

            ((LinkedList<Integer>) list).addFirst(treeNode.val);
        }

        return list;

    }
}
