package thread;


import java.util.concurrent.*;

/*
如何处理子线程的返回值
 */
public class MyTest {
    public void test1() throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        //用while轮询，等待子线程的返回结果
        myThread.start();
        while (myRunnable.getData() == null) {
            Thread.sleep(10);
        }
        System.out.println(myRunnable.getData());
    }

    public void test2() throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        //用join()方法，在子线程没有执行完毕前，主线程阻塞
        myThread.start();
        myThread.join();
        System.out.println(myRunnable.getData());
    }

    public void test3() throws InterruptedException, ExecutionException {
        /*
        使用Callable，FutureTask获取子线程的返回值
         */
        Callable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<String>(myCallable);
        Thread myThread = new Thread(futureTask);
        myThread.start();
        if (!futureTask.isDone()) {
            System.out.println("任务还没有完成");
        }
        String result = futureTask.get();
        System.out.println(result);
    }

    public void test4() {
        /*
        使用Callable，ThreadPool获取线程的返回值
         */
        Callable task = new MyCallable();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //向线程池中提交一个Callable任务
        Future<String> future = newCachedThreadPool.submit(task);
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            newCachedThreadPool.shutdown();
        }
        System.out.println(result);
    }



    public void test5() {
        Runnable myRunnable = new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("111");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("在阻塞状态下被中断了");
                    }
                }
                System.out.println("在正常运行时被中断了");
            }
        };

        Thread thread = new Thread(myRunnable);
        thread.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }





}
