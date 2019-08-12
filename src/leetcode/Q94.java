package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author starry
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * 迭代算法
 */
public class Q94 {

      private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 中序遍历 迭代法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            // 将其左子树全部push进栈
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            // pop出最后一个节点
            cur = stack.pop();
            // 也就是左子树的最左下节点
            res.add(cur.val);
            // 令cur = 右子树, 若没有右子树,就会跳过while循环将父节点变为cur.
            // 否则寻找右子树的最左节点
            cur = cur.right;
        }
        return res;
    }
}
