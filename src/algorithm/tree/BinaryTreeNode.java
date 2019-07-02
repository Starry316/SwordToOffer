package algorithm.tree;

import java.util.Scanner;

public class BinaryTreeNode {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int an =  sc.nextInt();
            int b = sc.nextInt();
            int bn = sc.nextInt();
            long arr[] = new long[n+1];
            arr[a] = an;
            arr[b] = bn;
            for (int i = n; i >= 1; i--) {
                for (int j = n; j >=1; j--) {
                    if (j>a)
                        arr[j] = Math.max(arr[j],arr[j-a]+1);
                    if (j>b)
                        arr[j] = Math.max(arr[j],1+arr[j-b]);

                }
            }
            System.out.println(arr[n]);
        }
    }
}
