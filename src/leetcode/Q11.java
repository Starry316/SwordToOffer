package leetcode;

/**
 * @Author starry
 * 11. 盛最多水的容器
 *
 * 思路:
 * 使用双指针,从头尾开始向中心遍历,寻找当前能够乘入的水体积
 */
public class Q11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int a[] = {1,8,6,2,5,4,8,3,7};
        new Q11().maxArea(a);
    }
}
