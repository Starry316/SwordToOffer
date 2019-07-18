package csp;

import java.util.Map;
import java.util.Scanner;


/**
 * @Author starry
 */
public class csp18092 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean timeLine[] = new boolean[1000000];
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {

            int s = sc.nextInt();
            int e = sc.nextInt();
            max = Math.max(e,max);

            for (int j = s; j < e; j++) {
                timeLine[j] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            max = Math.max(e,max);

            for (int j = s; j < e; j++) {
                if (timeLine[j]) count++;
//                timeLine[j] = true;
            }
        }

        System.out.println(count);
    }
}
