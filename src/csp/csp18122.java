package csp;

import java.util.Scanner;

/**
 * @Author starry
 *
 * 小明放学
 * 要点是计算当前是什么灯
 * 总耗时+灯已经走过的时间 % （y + r + g）
 */
public class csp18122 {
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
                // 红灯
//                if (pos == 1){
                switch(pos){
                    case 1 : pos = 0;break;
                    case 2 : pos = 2;break;
                    case 3 : pos = 1;break;
                }
                long left = sc.nextInt();
                long hasWait = light[pos] - left;
                long totalTimePass = count + hasWait;
                long moreTime = totalTimePass % (r+g+y);

                while (moreTime > light[pos]){
                    moreTime -= light[pos];
                    pos = (pos+1) % 3;
                }
                    // 红灯
                    if (pos == 0){
                        count+=(r-moreTime);
                    }
                    else if (pos == 2){
                        count+=(r+y-moreTime);
                    }
//                }
            }

        }
        System.out.println(count);
    }
}
