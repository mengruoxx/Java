package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
不推荐用这种方式创建线程池
这三种方式本质都是在用new ThreadPoolExecutor()方法创建
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //不限制个数
        ExecutorService executorService = Executors.newCachedThreadPool();
        //规定个数
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //只有一个
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }

}
