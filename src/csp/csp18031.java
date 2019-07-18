package csp;

import java.util.Scanner;

/**
 * @Author starry
 */
public class csp18031 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        int s = 0;
        int last = 1;
        while (sc.hasNextInt()){
            n = sc.nextInt();
            if (n == 0)break;
            if (n == 1){
                last = 1;
                s += 1;
            }
            else if (last == 1){
                s += 2;
                last = 2;
            }
            else {
                last += 2;
                s += last;
            }

        }


        System.out.println(s);
    }
}
