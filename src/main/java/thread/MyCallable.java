package thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    public String call() throws Exception {
        Thread.sleep(2000);
        return "myCallable 任务完成";
    }
}
