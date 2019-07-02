package sword2offer.q3;

/**
 * @Author starry
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 思路：由于数字范围为0 ~ n-1 在遍历数组的时候，利用下标，将num[num[i]]的值增加length
 * 如果发现该位置的值已经超过n了，说明出现重复。
 * 另外需要注意，如果num[i] > length 要先减去length
 *
 * 亮点: 利用下标计数，时间复杂度为O（n） 空间复杂度为 O（1）
 *
 */
public class Q3 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i++) {
            int num = numbers[i];
            if (num >= length)num-=length;
            if (numbers[num] > length){
                duplication[0] = num;
                return true;
            }
            else numbers[num]+=length;
        }
        duplication[0] = -1;
        return false;
    }
    public static void main(String []args){

        int [] in = {2,1,3,0,4};
        int [] res = {0};
        new Q3().duplicate(in,5,res);
    }
}
