package csp;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author starry
 */
public class csp19032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();sc.nextLine();
        for(int i= 0;i< n;i++){
            String s = sc.nextLine();
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(Integer.parseInt(s.charAt(0)+""));
            for (int j = 1; j < 7; j+=2) {
                if(s.charAt(j) == '-'){
                    stack.push(-Integer.parseInt(s.charAt(j+1)+""));

                }
                else if(s.charAt(j) == 'x'){
                    stack.push(stack.pop()*Integer.parseInt(s.charAt(j+1)+""));
                }
                else if(s.charAt(j) == '/'){
                    stack.push(stack.pop()/Integer.parseInt(s.charAt(j+1)+""));
                }
                else{
                    stack.push(Integer.parseInt(s.charAt(j+1)+""));
                }

            }
            int res = 0;
            while(!stack.isEmpty()){
                res+=stack.pop();
            }
            System.out.println(res==24?"Yes":"No");





        }
    }


}
