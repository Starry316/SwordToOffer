package csp;

import java.util.Scanner;

/**
 * @Author starry
 */
public class csp18091 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int res [] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 1){
            System.out.println(a[0]);
            return;
        }
        res[0] = (a[0] + a[1]) /2;

        for (int i = 1; i < n-1; i++) {
            res[i] = (a[i-1] + a[i] +a[i+1] )/3;
        }
        res[n-1] =( a[n-2] + a[n-1])/2;
        for (int i = 0; i < n-1; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println(res[n-1]);
    }
}
