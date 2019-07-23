package sword2offer.q41;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author starry
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 思路
 * 使用最大堆和最小堆将数据流分为两部分，最小堆中所有数据都要比最大堆中的大，同时最大堆和最小堆的数据个数差不能大于1
 * 奇数下标数据插入最大堆，偶数下标数据插入最小堆
 * 在插入时首先将数据插入另一个堆，然后将另一个堆中的最大/最小值出堆，插入目标堆
 */
public class Q41 {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(((o1, o2) -> o1.compareTo(o2)));
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
    private int count = 0;
    private int maxHeapSize = 0;
    private int minHeapSize = 0;
    public void Insert(Integer num) {
        count++;
        if ((count&1)==1){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
            maxHeapSize++;
        }else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            minHeapSize++;
        }

    }

    public Double GetMedian() {
        if ((count&1)==1){
            return Double.valueOf(maxHeap.peek());
        }else return (Double.valueOf(maxHeap.peek())+Double.valueOf(minHeap.peek()))/2;
    }
}
