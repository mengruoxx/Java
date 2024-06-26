package threadPool.demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProductBuyingDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(15));

        for (int i = 0; i < 20; i++) {
            pool.submit(new ProductBuyingTask());
        }
        pool.shutdown();
        int i = 9;

    }

}
