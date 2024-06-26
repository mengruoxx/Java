package reflect;

public class MyTest {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("/Users/mengruo/Desktop/Robot.class");
        try {
            Class<?> robot = myClassLoader.loadClass("Robot");
            System.out.println(robot.getClassLoader());;
            robot.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
