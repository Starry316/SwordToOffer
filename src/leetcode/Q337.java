package leetcode;

import java.util.LinkedList;

/**
 * @Author starry
 * 337. 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 */
public class Q337 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int rob(TreeNode root) {
        if (root == null)return 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<TreeNode> que2 = new LinkedList<>();
        que.addLast(root);
        int rb1 = 0;
        int rb2 = 0;
        while (!que.isEmpty()){
            TreeNode node = que.pollFirst();
            rb1+=node.val;
            if (node.left!=null)que2.addLast(node.left);
            if (node.right!=null)que2.addLast(node.right);
            if (!que2.isEmpty()){
                TreeNode node2 = que2.pollFirst();
                if (node2.left!=null)que.addLast(node2.left);
                if (node2.right!=null)que.addLast(node2.right);
                rb2+=node2.val;
            }
        }
        while (!que2.isEmpty()){
            TreeNode node = que.pollFirst();
            rb2+=node.val;

        }
        return Math.max(rb1,rb2);
    }
}
