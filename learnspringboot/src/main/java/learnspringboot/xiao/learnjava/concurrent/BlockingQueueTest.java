package learnspringboot.xiao.learnjava.concurrent;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author xzy
 * @date 2019-12-18 16:44
 * 说明：阻塞队列
 */
public class BlockingQueueTest {
    /**
     * FILE_QUEUE_SIZE - 阻塞队列容量
     * SEARCH_THREADS -
     * DUMMY -
     * blockingQueue - 阻塞队列
     */
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> blockingQueue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    public static void main(String[] args) {


    }
}
