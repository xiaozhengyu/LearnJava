package learnspringboot.xiao.learnjava.thread;

import lombok.Data;

/**
 * @author xzy
 * @date 2019-12-12 21:42
 * 说明：没有控制代码块并发访问
 */
public class Add {
    private Integer num1;
    private Integer num2;

    public Integer addNum(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
        return this.num1 + this.num2;
    }

    public static void main(String[] args) {
        Add add = new Add();
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
