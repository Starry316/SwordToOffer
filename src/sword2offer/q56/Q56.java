package sword2offer.q56;

/**
 * @Author starry
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路
 * 二分查找数字k第一次出现的位置和最后一次出现的位置
 */
public class Q56 {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0)return 0;
        int left = 0;
        int right = array.length-1;
        int mid = (left+right) >> 1;

        int fistKindex = 0;
        while (left<=right){
            if (array[mid] < k){
                left = mid+1;
            }
            else {
                right = mid-1;

            }
            mid = (left+right) >> 1;
        }
        fistKindex = left;
        left = 0;
        right = array.length-1;
        mid = (left+right) >> 1;
        int lastKindex = 0;
        while (left<=right){
            if (array[mid] <= k){
                left = mid+1;

            }
            else{
                right = mid-1;
            }
            mid = (left+right) >> 1;
        }
        lastKindex = right;
        return lastKindex - fistKindex+1;
    }

    public static void main(String[] args) {
//        int a[] = {1,2,3,3,3,4,5,6,7};
        int a[] = {1};
        new Q56().GetNumberOfK(a,1);
    }

}
