package sword2offer.q37;

import sword2offer.q3.Q3;

import java.util.LinkedList;

/**
 * @Author starry
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 思路：
 * 使用前序序列序列化树
 */
public class Q37 {
    String Serialize(TreeNode root) {
        StringBuffer sb= new StringBuffer();
        SerializeCore(root,sb);
        return sb.toString();
    }
    void SerializeCore(TreeNode root, StringBuffer sb){
        if (root == null)sb.append("#,");
        else {
            sb.append(root.val+",");
            SerializeCore(root.left,sb);
            SerializeCore(root.right,sb);
        }

    }

    TreeNode Deserialize(String str) {
        return doDeserialize(str);

    }
    int index = -1;
    TreeNode doDeserialize(String str){
        index ++;
        if (index >= str.length() )return null;

        String s[] = str.split(",");
        if (s[index].equals( "#")){
            return null;
        }

        TreeNode res = new TreeNode(Integer.parseInt(s[index]));
        res.left = doDeserialize(str);
        res.right = doDeserialize(str);
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
