package sword2offer.q50;

import java.util.HashMap;

/**
 * @Author starry
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Q50 {
    //num1,num2分别为长度为1的数组。传出参数，
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i]))
            map.put(array[i],2);
            else
            map.put(array[i],1);
        }
        boolean findOne= false;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1){
                if (!findOne){
                    num1[0]= array[i];
                    findOne = !findOne;
                }
                else num2[0]= array[i];
            }
        }
    }


    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0)return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),i);
            }else {
                map.put(str.charAt(i),-1);
            }
        }
        int min = 0x7fffffff;
        for (Integer value : map.values()) {
            if (value>-1) min = Math.min(min,value);
        }
        return min;

    }
    HashMap<Character,Integer> map = new HashMap<>();
    int count = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (!map.containsKey(ch)){
            map.put(ch,count++);
        }else {
            map.put(ch,-1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char res = '#';
        int min = 0x7fffffff;
        for (Character key : map.keySet()) {
            int value = map.get(key);
            if (value>-1) {
                if (value<min){
                    min = value;
                    res = key;
                }
            }
        }
        return  res;

    }
}
