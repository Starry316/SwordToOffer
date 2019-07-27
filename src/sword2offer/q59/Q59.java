package sword2offer.q59;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author starry
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Q59 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {

        ArrayList<Integer> res= new ArrayList<>();
        if (num.length == 0||size>num.length||size<=0)return res;
        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (que.isEmpty())que.add(num[i]);
            else {
                while (!que.isEmpty()&&que.peekLast() < num[i]){
                    que.pollLast();
                }
                que.addLast(num[i]);
            }
        }
        int left = 0;
        int right = size;

        for (; right < num.length; right++,left++) {
            if (num[left] == que.peekFirst()){
                res.add(que.pollFirst());
            }
            else res.add(que.peekFirst());
            if (que.isEmpty())que.add(num[right]);
            else {
                while (!que.isEmpty()&&que.peekLast() < num[right]){
                    que.pollLast();
                }
                que.addLast(num[right]);
            }
        }
        if (num[left] == que.peekFirst()){
            res.add(que.pollFirst());
        }
        else res.add(que.peekFirst());

        return res;
    }
}
