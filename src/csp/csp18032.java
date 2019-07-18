package csp;

import java.util.Scanner;

/**
 * @Author starry
 */
public class csp18032 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int t = sc.nextInt();
        int pos[] = new int[n];
        int dir[] = new int[n];
        int line[] = new int[l+1];
        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
            dir[i] = 1;
            line[pos[i]] = i;
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                line[pos[j]] = 0;
                pos[j]+=dir[j];
                line[pos[j]] = j;
            }
            for (int j = 0; j < n; j++) {
                if (pos[j] == l||pos[j]==0){
                    dir[j] = -dir[j];
                }
                else if (line[pos[j]]!=j){
                    dir[j] = - dir[j];
                    dir[line[pos[j]]] = - dir[line[pos[j]]];
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
            System.out.print(pos[i]+" ");
        }
        System.out.print(pos[n-1]);

    }
}
