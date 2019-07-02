package sword2offer.q8;

import sun.reflect.generics.tree.Tree;

/**
 * @Author starry
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 思路：如果该节点有右子节点，那么下个就是右子树的最左下方的节点
 * 如果没有右子节点，而且它是父节点的左子节点，那么下个一个就是父节点
 * 最复杂的情况是，如果它既不是父节点的左子节点又没有右子节点，那么就追溯到一个是其父节点的左子节点的节点
 * 如果没有。那么就是null了吧
 */
public class Q8 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 右子树非空
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }
        // 右子树为空
        else {
            // 父节点非空
            if (pNode.next != null){
                // 当前节点是父节点的左子节点
                if (pNode == pNode.next.left){
                    return pNode.next;
                }
                // 如果不是父节点的左子节点，就上溯到一个是父节点的左子节点的节点
                else {
                    TreeLinkNode node = pNode.next;
                    while (node != null){
                        if (node.next == null){
                            return null;
                        }
                        else {
                            if (node.next.left != node){
                                node = node.next;
                            }
                            else return node.next;
                        }
                    }
                }
            }
            else {
                return null;
            }

        }

        return null;
    }
    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
