package algorithm.sort;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QuickSort {
    public static void   sort(int arr[],int low,int high) {
        int left = low;
        int right = high;
        int pivot = arr[left];
        while (left < right){
            while (right>left&&pivot<=arr[right])
                right--;
            if (left<right)
                arr[left++] = arr[right];
            while (right>left&&pivot>=arr[left])
                left++;
            if (left<right)
                arr[right--] = arr[left];
        }
        arr[left] = pivot;
        if(left-1>low)sort(arr,low,right-1);
        if(right+1<high)sort(arr,left+1,high);
     }


    public static int[]  gennerateArray(int len,int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        Stack<Integer> s = new Stack<Integer>();

        Queue<node> queue= new ConcurrentLinkedQueue<node>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i*rows+j]== str[0]){
                    queue.add(new node(i,j,0));
                    boolean fund = false;
                    while (!queue.isEmpty()){
                        node n = queue.poll();
                        if (n.d == str.length-1){
                            fund = true;
                            return true;
                        }

                        for (int k = 0; k < 4; k++) {
                            int x = n.x+dir[k][0];
                            int y = n.x+dir[k][1];
                            int d = n.d+1;
                            if (x<rows&&x>=0&&y<cols&&y>=0)
                                if (matrix[x*rows+y] == str[d])
                                    queue.add(new node(x,y,d));
                        }
                    }
                }
            }
        }
        return false;

    }
    private class node{
        int x;
        int y;

        int d;
        node(int x,int y,int d){
            this.x = x;
            this.y = y;

            this.d = d;
        }
    }
     public static void main(String args[]){
        int a[] = gennerateArray(1000000,100000) ;
        java.util.Date date = new Date();
         long st = date.getTime();
        sort(a,0,a.length-1);
        long et = new Date().getTime();
         System.out.println(et-st);
//         for (int i = 0; i < a.length; i++) {
//             System.out.println(a[i]);
//         }
     }
}
