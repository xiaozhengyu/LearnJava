package learnspringboot.xiao.learnjava.thread;

/**
 * @author xzy
 * @date 2019-12-14 14:12
 * 说明：
 */
public class Synchronization {
    private boolean trueOrFalse;
    public void set(boolean trueOrFalse) {
        System.out.println("线程：" + Thread.currentThread().getName() + " 赋值：" + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public boolean isTrue() {
        System.out.println("线程：" + Thread.currentThread().getName() + " 取值：" + this.trueOrFalse);
        return this.trueOrFalse;
    }

    public static void main(String[] args) {
        Synchronization sync = new Synchronization();
        Thread thread1 = new Thread(() -> {
            sync.set(true);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sync.isTrue();
        });
        Thread thread2 = new Thread(() -> {
            sync.set(false);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sync.isTrue();
        });
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
        while (true) {

        }
    }
}
