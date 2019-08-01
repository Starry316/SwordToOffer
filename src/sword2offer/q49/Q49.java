package sword2offer.q49;

import java.util.ArrayList;

/**
 * @Author starry
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 *
 * 思路：
 * 维护三个队列，每个队列分别计算235的倍数，每次将3个队列中最小值加入结果。
 * 我们没有必要维护三个队列，只需要记录三个指针显示到达哪一步
 */
public class Q49 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        //add进第一个丑数1
        list.add(1);
        //三个下标用于记录丑数的位置
        int i2=0,i3=0,i5=0;
        while(list.size()<index){
            //三个数都是可能的丑数，取最小的放进丑数数组里面
            int n2=list.get(i2)*2;
            int n3=list.get(i3)*3;
            int n5=list.get(i5)*5;
            int min = Math.min(n2,Math.min(n3,n5));
            list.add(min);
            if(min==n2)
                i2++;
            if(min==n3)
                i3++;
            if(min==n5)
                i5++;
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        Q49 q =new Q49();
        q.GetUglyNumber_Solution(12);
    }
}
