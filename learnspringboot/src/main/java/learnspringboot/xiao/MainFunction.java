package learnspringboot.xiao;


import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 肖政宇
 * @date 2019-10-23 16:22
 * 说明：
 */
@Data
public class MainFunction {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = new ThreadPoolExecutor();
    }
}
