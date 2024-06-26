package io;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author mengruo
 * @date 2022/12/23 16:39
 * ((A>0 && B>0) || !(C>0 && D>0))
 */
public class IOStream {

    public static void main(String[] args) {

        byte[] buf = new byte[512];
        System.out.println("hey, may I have your name, please? ");
        int n = 0;
        try {
            n = System.in.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("hello, ");
        System.out.write(buf, 0, n);

        // InputStreamReader可以接收char[]类型，是一个适配器
        char[] cbuf = new char[256];
        System.out.println("hey, may I have your name, please? ");
        int n1 = 0;
        Reader r = new InputStreamReader(System.in);
        try {
            n1 = r.read(cbuf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("hello, Mr. " + cbuf[0]);
    }
}
