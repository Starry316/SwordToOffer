package sword2offer.q57;

import java.util.ArrayList;

/**
 * @Author starry
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 *
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 思路：
 * 滑动窗口，
 */
public class Q57 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array.length <=1)return res;
        int left = 0;
        int right = array.length-1;
        while (left < right){
            if (array[left]+array[right] > sum){
                right--;

            }
            else if (array[left]+array[right]  == sum){

                res.add(array[left]);
                res.add(array[right]);
                break;
            }
            else {

                left++;
            }
        }
        return res;
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int windowSize = 1;
        int left = 0;
        int right = 1;
        int s = 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (left < right){
            if (s < sum){
                right++;
                s+=right;
            }
            else if (s == sum){
                ArrayList<Integer> item = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    item.add(i);
                }
                res.add(item);
                s-=left;
                left++;
            }
            else {
                s-=left;
                left++;
            }
        }
        return res;

    }
}
