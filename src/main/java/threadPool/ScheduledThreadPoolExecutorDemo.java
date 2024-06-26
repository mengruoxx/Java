package threadPool;

import java.util.concurrent.*;
/*
可调度的线程池
 */
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4)  ;
        //延迟三秒执行
//        scheduledExecutorService.schedule(new MyRunnable(), 3, TimeUnit.SECONDS);
        //延迟一秒执行，每三秒执行一次
//        scheduledExecutorService.scheduleAtFixedRate(new MyRunnable(), 1, 3, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }

}
