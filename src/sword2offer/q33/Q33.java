package sword2offer.q33;

/**
 * @Author starry
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 注意是二叉搜索树
 */
public class Q33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length == 0)return false;
        return verifySquenceOfBstCore(sequence,0,sequence.length-1);
    }
    public boolean verifySquenceOfBstCore(int [] seq, int left ,int right){

            if (left >= right)return true;


            int root = seq[right];
            int i = left;
            for (; i < right; i++) {
                if (seq[i]>root){
                    break;
                }
            }
            for (int j = i; j < right; j++) {
                if (seq[j]<root)return false;
            }
            boolean isLeftOk = true;
            if (i>0)
                isLeftOk = verifySquenceOfBstCore(seq,left,i-1);

            boolean isRightOk = true;
            if (i<right)
                isRightOk = verifySquenceOfBstCore(seq,i,right-1);
            return isLeftOk
                    && isRightOk;





    }
    public static void main(String args[]){
        int a []  = {4,8,6,12,16,14,10};
//        int a []  = {4 };
        boolean res = new Q33().VerifySquenceOfBST(a);
        System.out.println(res);
    }
}
