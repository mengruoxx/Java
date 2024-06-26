package threadPool.demo;

public class ProductBuyingTask implements Runnable {
    private volatile static int storage = 10;
    public void run() {
        synchronized (ProductBuyingTask.class) {
            if (storage > 0) {
                storage--;
                System.out.println("成功购买到商品 " + Thread.currentThread().getName()+" 库存为:"+storage);
            } else {
                System.out.println("购买失败"+" 库存为:"+storage);
            }
        }
    }
}
