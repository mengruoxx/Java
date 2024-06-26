package singleton;
/*
volatile双重检测单例模式
 */
public class SingletonDemo {
    private static volatile SingletonDemo instance;

    private SingletonDemo() {

    }

    public SingletonDemo getInstance() {
        if (instance == null) {
            //注意这里是类锁，这个都是私有的构造方法了，得不到对象锁
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
