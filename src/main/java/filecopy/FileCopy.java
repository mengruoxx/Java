package filecopy;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File source = new File("/Users/mengruo/Desktop/传输层.md");
        File target = new File("/Users/mengruo/Desktop/传输层1.md");
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            byte[] b = new byte[1024];
            int len;
            while ((len = in.read(b)) != -1) {
                out.write(b,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
