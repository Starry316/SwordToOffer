package sword2offer.q31;

import java.util.Stack;

/**
 * @Author starry
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Q31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<Integer>();
        int countPopA = 0;
        int countPushA = 0;
        while(countPopA < popA.length){
            if(s.isEmpty()){
                s.push(pushA[countPushA++]);
            }

            if(popA[countPopA] !=s.peek()){
                if(countPushA==pushA.length)
                    return false;
                s.push(pushA[countPushA++]);
            }
            else{
                countPopA++;
                s.pop();
            }
        }
        return true;
    }
//    public boolean IsPopOrder(int [] pushA,int [] popA) {
//        Stack<Integer> s = new Stack<Integer>();
//        int countPopA = 0;
//        int countPushA = 0;
//        while(countPopA < popA.length){
//            if(s.isEmpty()&&countPushA<pushA.length){
//                s.push(pushA[countPushA++]);
//            }
//
//            if(popA[countPopA] !=s.peek()){
//                if(countPushA==pushA.length)
//                    return false;
//                s.push(pushA[countPushA++]);
//            }
//            else{
//                countPopA++;
//                s.pop();
//            }
//        }
//        return true;
//    }
}
