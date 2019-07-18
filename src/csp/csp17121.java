package csp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author starry
 */
public class csp17121 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int min = 0xfffffff;
        for (int i = 1; i < n; i++) {
            min = Math.min(a[i] - a[i-1],min);
        }

        System.out.print(min);

    }
}
