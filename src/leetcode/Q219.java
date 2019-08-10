package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author starry
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * \
 *
 *  思路
 *  滑动窗口
 */
public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right<nums.length){
            if (right - left > k){
                set.remove(nums[left++]);
            }
            else {
                if (set.contains(nums[right])){
                    return true;
                }
                else {
                    set.add(nums[right]);
                }
                right++;
            }

        }
        return false;
    }
}
