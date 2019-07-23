package sword2offer.q37;

import sword2offer.q3.Q3;

import java.util.LinkedList;

/**
 * @Author starry
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Q37 {
    String Serialize(TreeNode root) {
        StringBuffer sb= new StringBuffer();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root == null)return sb.append('$').toString();
        list.add(root);
        while (!list.isEmpty()){
            TreeNode node = list.pollFirst();
            if (node == null)sb.append('$');
            else {
                sb.append(node.val);
                list.addLast(node.left);
                list.addLast(node.right);
            }

        }
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        return doDeserialize(str,0);

    }
    TreeNode doDeserialize(String str,int index){
        if (index >= str.length() )return null;
        if (str.charAt(index) == '$'){
            return null;
        }
        TreeNode res = new TreeNode(Integer.parseInt(str.charAt(index)+""));
        res.left = doDeserialize(str,index+1);
        res.right = doDeserialize(str,index+2);
        return res;
    }

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(3);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);

        a3.left = a2;
        a2.left = a1;
        a3.right = a4;
        a4.left = a6;
        a4.right = a5;
        String res = new Q37().Serialize(a3);
        System.out.println(res);
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
