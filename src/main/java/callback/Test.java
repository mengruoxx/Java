package callback;

public class Test {
    public static void main(String[] args) {
        com.imooc.interview.javabasic.callback.ICallback callback = new CallbackImpl();
        Controller controller = new Controller(callback);
        controller.begin();
    }
}
