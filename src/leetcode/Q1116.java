package leetcode;

import java.util.concurrent.SynchronousQueue;
import java.util.function.IntConsumer;

/**
 * @Author starry
 */
public class Q1116 {
    private int n;

    public Q1116(int n) {
        this.n = n;
    }
    private static final Object lock = new Object();
    private static volatile Integer print = 0;
    private static volatile Boolean printZero = true;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (print<n) {
            synchronized (lock) {

                while (!printZero) {

                    lock.wait();
                }
                synchronized (printZero) {
                    printZero = false;
                }
                synchronized (print){
                    print++;
                }

                printNumber.accept(0);

                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (print<=n) {
            synchronized (lock) {

                while (printZero || print % 2 != 0) {
                    if (print == n)return;

                    lock.wait();

                }

                printNumber.accept(print);
                synchronized (printZero) {
                    printZero = true;
                }
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (print<=n) {
 
            synchronized (lock) {

                while (printZero || print % 2 != 1) {
                    if (print == n)return;

                    lock.wait();

                }
                printNumber.accept(print);
                synchronized (printZero){
                    printZero = true;
                }


                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Q1116 q = new Q1116(5);
        Thread t1 = new Thread(()->{
            try {
                q.even(x -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                q.odd(x -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(()->{
            try {
                q.zero(x -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t4.start();
        t3.start();
    }
}
