import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 一个简单的web服务器
 * 不是什么特别难的
 * 以前都是用python写服务器
 * 第一次用java
 * 所以参考部分API及网络资料
 * Created by BG on 2017/4/18.
 */

public class WebServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "htmlfile";
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    private boolean shutdown = false;

    public static void main(String[] args) {
        WebServer server = new WebServer();
        server.start();
    }

    //启动服务器，并接收用户请求进行处理
    public void  start() {
        ServerSocket serverSocket = null;
        // 常用端口可能会冲突，但是简易服务器用用也无所谓吧
        int port = 1234;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        //若请求的命令不为SHUTDOWN时，循环处理请求
        while(!shutdown) {

            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;

            try {
                //创建socket进行请求处理
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                //接收请求
                Request request = new Request(input);
                request.parser();
                //处理请求并返回结果
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();
                //关闭socket
                socket.close();
                //若请求命令为关闭，则关闭服务器
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
