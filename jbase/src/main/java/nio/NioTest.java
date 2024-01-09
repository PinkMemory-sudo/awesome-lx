package nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static void main(String[] args) {
//        readFile("E:\\Users\\LAN-IT-0212\\Desktop\\em_push\\emer_push_schedule.sql");
        writeFile("E:\\Users\\LAN-IT-0212\\Desktop\\em_push\\emer_push_schedule.sql.bak");
    }

    public static void readFile(String fileName) {
        RandomAccessFile aFile = null;
        try {
            //文件流
            aFile = new RandomAccessFile(fileName, "rw");
            //将文件输入到管道
            FileChannel inChannel = aFile.getChannel();
            //为buffer分配1024个字节大小的空间
            ByteBuffer buf = ByteBuffer.allocate(2028);
            //将buffer中的内容读取到管道中
            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {
                //反转buffer，将写模式改为读模式
                buf.flip();
                while (buf.hasRemaining()) {
                    //获取buffer中的数据
                    System.out.print((char) buf.get());
                }
                //将上次分配的1024字节的内容清空，为下次接收做准备
                buf.clear();
                //管道重新读取buffer中的内容
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName) {
        RandomAccessFile aFile = null;
        try {
            //文件流
            aFile = new RandomAccessFile(fileName, "rw");
            //将文件输入到管道
            FileChannel inChannel = aFile.getChannel();
            //为buffer分配1024个字节大小的空间
            ByteBuffer buf = ByteBuffer.allocate(2028);
            inChannel.write(ByteBuffer.wrap("hello".getBytes()));
            //将buffer中的内容读取到管道中
//            int bytesRead = inChannel.read(buf);
//            while (bytesRead != -1) {
//                //反转buffer，将写模式改为读模式
//                buf.flip();
//                while (buf.hasRemaining()) {
//                    //获取buffer中的数据
//                    System.out.print((char) buf.get());
//                }
//                //将上次分配的1024字节的内容清空，为下次接收做准备
//                buf.clear();
//                //管道重新读取buffer中的内容
//                bytesRead = inChannel.read(buf);
//            }
            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
