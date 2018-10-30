import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by BG on 2017/4/24.
 */
public class PopClient {

    private static BufferedReader in; // 从套接字中读取文本
    private static PrintStream out; // 将文本写入套接字

    public static void main(java.lang.String[] args) {
        // 用户名
        String username = "";
        // 密码
        String password = "";
        // Pop服务器名，这里我用的是武汉大学电子邮箱的服务器
        String popServer = "pop.whu.edu.cn";
        // 设置标志位
        boolean delete = false;
        boolean secure = false;
        Socket socket;
        String line;
        String numberMessages;
        try {
            if (args.length == 2) {
                // 从命令行中取用户名和密码
                username = args[0];
                password = args[1];
            } else
                System.out.println("Usage:\r\n: java PopExample <PopServer> <username> <password>");
            System.out.println("Connecting to " + popServer + " ...");
            // Pop3服务默认使用110端口
            // 建立TCP连接
            socket = new Socket(popServer,110);
            System.out.println("Connected\nAuthentication in progress...");
            // 连接建立成功，获得关联的输入流和输出流
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
            // 这一行响应是服务器的欢迎信息，可省略
            line = readFromInputStream();
            // 发送用户名
            printToOutputStream("USER " + username);
            // 如果用户存在，则响应信息开头有+OK字样。否则退出
            if (!readFromInputStream().startsWith("+OK")) {
                System.out.println("Wrong user name， disconnecting");
                socket.close();
                System.exit(1);
            }
            // 用户名存在，则发送密码
            out.println("PASS " + password);
            System.out.println("R: PASS ********");
            // 读服务器响应信息
            line = readFromInputStream();
            // 如果密码核对成功，响应信息中开头+OK字样
            if (!line.startsWith("+OK")) {
                // 密码不正确，无法继续
                System.out.println("Wrong password， disconnecting");
                socket.close();
                System.exit(1);
            }
            // 命令STAT
            printToOutputStream("STAT");
            // 读取响应
            line = readFromInputStream();
            if (!line.startsWith("+OK")) {
                //如果命令执行失败，则退出
                System.out.println("Error:" + line);
                socket.close();
                System.exit(1);
            }
            // 从统计信息中抽取消息个数
            int i = line.lastIndexOf(' ');
            numberMessages = line.substring(4, i);
            System.out.println("You have " + numberMessages + " message(s) in your mailbox");
            // 获取消息个数
            int n = Integer.parseInt(numberMessages);
            int numberBytes;
            // 取出服务器上的每一个消息
            for (int msg = 1; msg <= n; msg++) {
                System.out.println("Retreaving message " + msg);
                // 命令RETR 用于收取消息
                printToOutputStream("RETR " + msg);
                // 从服务器读取消息
                line = readFromInputStream();
                if (!line.startsWith("+OK")) {
                    System.out.println("Error: " + line);
                    socket.close();
                    System.exit(1);
                }
                // 消息以“.”号结束，一行中连续两个"."代表"."
                line = in.readLine();
                while (line.compareTo(".") != 0) {
                    if (line.compareTo("..") == 0)
                        System.out.println(".");
                    else
                        System.out.println(line);
                    // 读取下一行
                    line = in.readLine();
                }
                // 消息已读取到本地，从服务器删除消息
                // 删除消息的命令是DELE [messagenumber]
                printToOutputStream("DELE " + msg);
                readFromInputStream();
            }
            // 准备退出，使用QUIT命令
            printToOutputStream("QUIT");
            readFromInputStream();
            // 关闭套接字
            socket.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
    // 方法printToOutputStream()向SMTP服务器发送命令
    private static void printToOutputStream(String s) throws IOException {
        System.out.println("S : " + s);
        out.println(s);
        return;
    }
    // 方法readFromInputStream()接收从SMTP服务器发回的响应信息
    private static String readFromInputStream() throws IOException {
        String s = in.readLine();
        if (s != null)
            System.out.println("R :" + s);
        return s;
    }

}
