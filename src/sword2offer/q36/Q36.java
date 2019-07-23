package sword2offer.q36;



/**
 * @Author starry
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Q36 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode cur = null;
        doConvert(pRootOfTree, cur);
        TreeNode res = pRootOfTree;
        while (res.left!=null){
            System.out.println(res.val);
            res = res.left;
        }
        return res;
    }
    public void doConvert(TreeNode root,TreeNode cur){
        if (root == null) return;

        doConvert(root.left, cur);

        root.left = cur;
        if (cur!=null)
            cur.right = root;
        cur = root;
        doConvert(root.right, cur);


    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);

        a3.left = a2;
        a2.left = a1;
        a3.right = a4;
        a4.right = a5;

        TreeNode s = new Q36().Convert(a3);

//        System.out.print(a1.val);
//        if (a1.left !=null)
//        System.out.print("left: "+a1.left.val);
//        if (a1.right !=null)
//        System.out.print("left: "+a1.right.val);
//        System.out.println();
//
//
//        System.out.print(a2.val);
//        if (a2.left !=null)
//            System.out.print("left: "+a2.left.val);
//        if (a2.right !=null)
//            System.out.print("left: "+a2.right.val);
//        System.out.println();
//
//
//        System.out.print(a3.val);
//        if (a3.left !=null)
//            System.out.print("left: "+a3.left.val);
//        if (a3.right !=null)
//            System.out.print("left: "+a3.right.val);
//        System.out.println();
//
//
//        System.out.print(a4.val);
//        if (a4.left !=null)
//            System.out.print("left: "+a4.left.val);
//        if (a4.right !=null)
//            System.out.print("left: "+a4.right.val);
//        System.out.println();
//
//
//        System.out.print(a5.val);
//        if (a5.left !=null)
//            System.out.print("left: "+a5.left.val);
//        if (a5.right !=null)
//            System.out.print("left: "+a5.right.val);
//        System.out.println();
//
//
//
//        while (s!=null){
//            System.out.println(s.val+" ");
//            s = s.right;
//        }
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
