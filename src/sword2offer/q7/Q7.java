package sword2offer.q7;

/**
 * @Author starry
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 *思路 前序遍历的第一个数是根节点，根节点后分别是左子树和右子树
 * 中序遍历根节点左边的是左子树，右边是右子树
 * 首先根据前序遍历确定第一个根节点，然后再去中序遍历确认左子树的节点数。
 * 当前前序遍历 [开始位置+1, 前序遍历开始位置+节点数] [前序遍历开始位置+节点数+1, 结束位置] 为左右子树 的前序遍历
 * 当前中序遍历 [开始位置, 根节点位置-1] [根节点位置+1, 结束位置] 为左右子树的中序遍历
 * 这样就可以递归地将问题划分为一系列相同子问题
 */
public class Q7 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) return null;
        return this.constuctBinaryTree(pre, 0,pre.length-1, in,0, in.length-1);
    }
    public TreeNode constuctBinaryTree(int [] pre, int preSt,int preEn, int [] in, int inSt, int inEn){
        // 前序遍历起始位置为根节点
        int rootVal = pre[preSt];
        TreeNode root = new TreeNode(rootVal);
        // 开始和结束位置相同，说明没有子树
        if (inSt == inEn && preSt == preEn) return root;
        // 记录左子树节点个数
        int leftChildCount = 0;
        for (;leftChildCount+inSt<inEn;leftChildCount++)
            if (in[leftChildCount+inSt] == rootVal){
                break;
            }
        // 如果左子树节点个数大于0
        if (leftChildCount>0)
            root.left = this.constuctBinaryTree(pre, preSt+1,preSt+leftChildCount, in,inSt, inSt+leftChildCount-1);
        // 计算右子树节点个数
        if (leftChildCount<inEn-inSt)
            root.right = this.constuctBinaryTree(pre, preSt+leftChildCount+1,preEn, in,inSt+leftChildCount+1, inEn);
        return root;
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String []args){
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        new Q7().reConstructBinaryTree(pre,in);
    }
}
