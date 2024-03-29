package sword2offer.q4;

/**
 * @Author starry
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：每次判断右上角的元素，有三种情况
 * 如果右上角元素大于目标，可以剔除最后一列（最小大于目标值）
 * 如果右上角元素小于目标，可以剔除第一行（最大小于目标值）
 * 等于目标，找到该值
 */
public class Q4 {
    public boolean Find(int target, int [][] array) {
        int rowMax = 0;
        int colMax = array[0].length-1;
        if (colMax < 0)return false;
        while (rowMax < array.length && colMax >= 0){
            if (array[rowMax][colMax] > target)
                colMax --;
            else if (array[rowMax][colMax] < target)
                rowMax ++;
            else return true;
        }
        return false;
    }
}
