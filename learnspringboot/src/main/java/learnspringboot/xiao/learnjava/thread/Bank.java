package learnspringboot.xiao.learnjava.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xzy
 * @date 2019-12-13 11:01
 * 说明：模拟银行转账
 */
public class Bank {
    private Map<String, Double> accountMap = new HashMap<>();
    private Lock myLock = new ReentrantLock();
    private Condition haveMoney = myLock.newCondition();

    public Bank() {
        this.accountMap.put("ZhangSan", 100.0);
        this.accountMap.put("WangWu", 1000.0);
    }

    public void transfer(String from, String to, Double money) {
        //线程执行后面的代码段需要先获得锁，获取不到就挂起。
        myLock.lock();
        System.out.println("当前获得锁的线程：" + Thread.currentThread().getName());
        System.out.println(from + "想给" + to + "转" + money + "元," + from + "现在有" + accountMap.get(from) + "元");
        try {
            while (accountMap.get(from) < money) {
                System.out.println("线程阻塞：" + Thread.currentThread().getName());
                //获取到锁的线程需要等待本条件成立，条件成立前将锁释放，线程阻塞。
                haveMoney.await();
            }
            accountMap.put(from, accountMap.get(from) - money);
            accountMap.put(to, accountMap.get(to) + money);
            System.out.println(from + "转给" + to + money + "元  线程：" + Thread.currentThread().getName());
            //通知因本条件而挂起的线程，条件现在可能已经满足，可以试着再去获取肯看。
            haveMoney.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread thread1 = new Thread(() -> {
            bank.transfer("ZhangSan", "WangWu", 500.0);
        });
        Thread thread2 = new Thread(() -> {
            bank.transfer("WangWu", "ZhangSan", 1000.0);
        });
        Thread thread3 = new Thread(() -> {
            bank.transfer("ZhangSan", "WangWu", 500.0);
        });
        thread1.setName("张三给王五500 x1");
        thread2.setName("王五给张三1000");
        thread3.setName("张三给王五500 x2");
        thread1.start();
        thread2.start();
        thread3.start();
        while (true) {

        }
    }
}
