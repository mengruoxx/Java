package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author mengruo
 * @date 2024/1/8 18:59
 */
public class NIODemo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/mengruo/IdeaProjects/mengruo/java-related/README.md");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 构建通道，这个通道是JVM和操作系统的通道
        FileChannel channel = fileInputStream.getChannel();
        // 分配一个缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1);
//        ByteBuffer.allocateDirect()
        // 开始读
        int readNum = channel.read(buffer);

        buffer.flip();
    }
}
