package read;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Socket {
    @Test
    public void client() {
        OutputStream os = null;
        java.net.Socket socket = null;
        try {
            InetAddress inet = InetAddress.getByName("192.168.0.174");
            socket = new java.net.Socket(inet, 8090);
            os = socket.getOutputStream();
            os.write("ok吗".getBytes());
        } catch (Exception e) {

        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void Server() {
        ServerSocket ss = null;
        java.net.Socket accept = null;
        BufferedReader input = null;
        try {
            ss = new ServerSocket(8090);
            accept = ss.accept();
            // InputStream is = accept.getInputStream();
// 读取客户端数据
            input = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            String clientInputStr = input.readLine();//这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
            // 处理客户端数据
            System.out.println("客户端发过来的内容:" + clientInputStr);
        } catch (Exception e) {

        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
