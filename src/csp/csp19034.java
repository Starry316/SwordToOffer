package csp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author starry
 */
public class csp19034 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            ArrayList<LinkedList<Integer>> listArr = new ArrayList<LinkedList<Integer>>();

            for (int j = 0; j < n; j++) {
                LinkedList<Integer> list = new LinkedList<Integer>();
                String cmdList = sc.nextLine();
                String cmd[] = cmdList.split(" ");
                for (int k = 0; k < cmd.length; k++) {
                    int num = Integer.parseInt(cmd[k].substring(1)) + 1;
                    if (cmd[k].charAt(0) == 'S') {
                        num = -num;
                    }
                    list.add(num);
                }
                listArr.add(list);
            }

            int res = 1;
            while (true) {
                if (res == 0) break;
                res = 0;
                for (int j = 0; j < n; j++) {
                    if (listArr.get(j).isEmpty()) continue;
                    if (listArr.get(j).peekFirst() < 0) {
                        int to = listArr.get(j).peekFirst();

                        if (listArr.get(Math.abs(to) - 1).isEmpty()) continue;

                        if (listArr.get(Math.abs(to) - 1).peekFirst() - 1 == j) {
                            listArr.get(j).pop();
                            listArr.get(Math.abs(to) - 1).pop();
                            res = 1;
                        }

                    }

                }
            }

            for (int j = 0; j < n; j++) {
                if (!listArr.get(j).isEmpty()) {
                    System.out.println(1);
                    break;
                } else {
                    if (j == n - 1)
                        System.out.println(0);
                }

            }


        }
    }

}
