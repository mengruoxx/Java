package callback;

import java.util.Scanner;

public class Controller {
    private com.imooc.interview.javabasic.callback.ICallback callback;
    private Scanner input = new Scanner(System.in);

    public Controller(com.imooc.interview.javabasic.callback.ICallback callback) {
        this.callback = callback;
    }

    public void begin() {
        while (input.next()!=null) {
            callback.run();
        }
    }
}
