package thread;

public class MyRunnable implements Runnable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i的值为"+i);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data="I have data now";
        System.out.println("为data赋值完成");
    }
}
