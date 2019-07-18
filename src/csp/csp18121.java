package csp;

import java.util.Scanner;

/**
 * @Author starry
 */
public class csp18121 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long r = sc.nextInt();
        long y = sc.nextInt();
        long g = sc.nextInt();
        long light[] = {r,g,y};
        long n = sc.nextInt();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            if (pos == 0){
                count+=sc.nextInt();
            }
            else {

                if (pos == 1 ){
                    count+=sc.nextInt();
                }
                else if (pos == 2){
                    count+=sc.nextInt()+r;
                }

                else sc.nextInt();
            }

        }
        System.out.println(count);
    }
}
