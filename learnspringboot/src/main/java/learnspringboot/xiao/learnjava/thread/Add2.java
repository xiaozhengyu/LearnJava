package learnspringboot.xiao.learnjava.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xzy
 * @date 2019-12-12 21:55
 * 说明：使用锁控制代码块并发访问的实例
 */
public class Add2 {
    private Integer num1;
    private Integer num2;
    private Lock myLock = new ReentrantLock();

    public Integer addNum(Integer num1, Integer num2) {
        myLock.lock();
        System.out.println("当前进入临界区的线程：" + Thread.currentThread());
        try {
            this.num1 = num1;
            this.num2 = num2;
            return this.num1 + this.num2;
        } finally {
            //保证锁最终会被释放
            myLock.unlock();
        }
    }

    public static void main(String[] args) {
        Add2 add = new Add2();
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("1+1 = " + add.addNum(1, 1));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("2+2 = " + add.addNum(2, 2));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.setName("线程1：计算1+1");
        thread2.setName("线程2：计算2+2");
        thread1.start();
        thread2.start();
        while (true) {
        }
    }
}
