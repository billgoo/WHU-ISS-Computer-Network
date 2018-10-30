import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by BG on 2017/4/18.
 */
public class Response {

    private OutputStream output;
    private  Request request;
    private static final int BUFFER_SIZE = 1024;

    public Response(OutputStream output) {
        this.output = output;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    // 发送一个静态资源给客户端，若本地服务器有对应的文件则返回，否则返回404页面
    public void sendStaticResource() {
        byte[] buffer = new byte[BUFFER_SIZE];
        int ch;
        FileInputStream fis = null;
        try {
            File file = new File(WebServer.WEB_ROOT, request.getUri());
            if(file.exists()) {
                fis = new FileInputStream(file);
                ch = fis.read(buffer);
                while(ch != -1) {
                    output.write(buffer, 0, ch);
                    ch = fis.read(buffer, 0, BUFFER_SIZE);
                }
            } else {
                String errorMessage = "HTTP/1.1 404 File Not Found \r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 24\r\n" +
                        "\r\n" +
                        "<h1>404 Not Found<br></h1>";

                if (request.getUri().equals("/SHUTDOWN")){
                    String endMessage = "HTTP/1.1 Close Server \r\n" +
                            "Content-Type: text/html\r\n" +
                            "Content-Length: 24\r\n" +
                            "\r\n" +
                            "<h1>Close Server<br></h1>";

                    output.write(endMessage.getBytes());
                }else {
                    output.write(errorMessage.getBytes());
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
