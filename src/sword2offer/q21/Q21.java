package sword2offer.q21;

import java.util.LinkedList;

/**
 * @Author starry
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * 思路
 * 如果没有要求顺序不变 维护两个指针指向尾部最后一个奇数和头部最开始一个偶数，O（n）遍历交换即可
 * 但是若要求顺序不变，用队列解决
 */

public class Q21 {
    public void reOrderArray(int [] array) {
        LinkedList<Integer> listOdd = new LinkedList<Integer>();
        LinkedList<Integer> listEven = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (isOdd(array[i]))listOdd.add(array[i]);
            else listEven.add(array[i]);
        }
        int i = 0;
        while (!listOdd.isEmpty()){
            array[i++] = listOdd.getFirst();
            listOdd.removeFirst();
        }
        while (!listEven.isEmpty()){
            array[i++] = listEven.getFirst();
            listEven.removeFirst();
        }
    }
    public void swap(int a[], int i,int j){
        int t = a[i];
        a[i]= a[j];
        a[j] = t;
    }
    public boolean isOdd(int n){
        if ((n&1) == 1)return true;
        return false;
    }
}
