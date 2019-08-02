package leetcode;

import java.util.PriorityQueue;

/**
 * @Author starry
 *
 * 215. 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        if (k <= 0)return 0;
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (minQue.size() < k)minQue.offer(nums[i]);
            else {
                if (minQue.peek() < nums[i]){
                    minQue.poll();
                    minQue.offer(nums[i]);
                }
            }
        }
        return minQue.peek();
    }
}
