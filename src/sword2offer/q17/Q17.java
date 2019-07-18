package sword2offer.q17;

import java.util.LinkedList;

/**
 * @Author starry
 */
public class Q17 {
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
    public static void main(String []args){

        int [] in = {1,2,3,4,5,6,7};

        new Q17().reOrderArray(in);
    }
}
