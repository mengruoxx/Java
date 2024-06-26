package reflect;

import java.io.*;

/*
自定义类加载器:
1.新建类继承ClassLoader
2.重写findClass方法，方法返回一个Class对象，
在其中读取class字节码文件，转换成字节数组byte[], 传到defineClass()方法中返回Class对象
3.调用该自定义类加载器的loadClass方法
 */
public class MyClassLoader extends ClassLoader {
    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获取字节数组
        byte[] b = getData();
        //将字节码数组转换成Class类实例
        return defineClass(name, b, 0, b.length);
    }

    /*
    将字节码文件转换成字节数组返回
     */
    private byte[] getData() {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(path);
            out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int size =0;
            while ((size=in.read(b)) != -1) {
                out.write(b,0,size);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
