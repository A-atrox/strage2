package smt.io.BIO;

import org.apache.catalina.Server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author guoyf
 * @Date 2020/7/30
 * @describe
 */
public class BioServer {
    private static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int reader = inputStream.read(bytes);
                if (reader != -1) {
                    System.out.println(new String(bytes,0,reader));
                }else {
                    break;
                }
            }
        } catch (SocketException socketException){
            try {
                System.out.println("Socket 关闭");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("BIO服务器启动0....0");
        while(true){
            final  Socket socket = serverSocket.accept();
            System.out.println("有一个新链接0....0");
            handler(socket);
        }
    }
}
