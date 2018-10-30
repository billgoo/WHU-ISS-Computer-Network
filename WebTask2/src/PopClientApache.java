import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;

import java.io.BufferedReader;
import java.io.Reader;

/**
 * Created by BG on 2017/4/25.
 */
public class PopClientApache {

    public static void main(String[] args) {
        POP3Client pop3 = new POP3Client();
        try {

            pop3.setDefaultPort(110);
            pop3.connect("pop.whu.edu.cn");
            // 我测试的是QQ邮件～
            // 输入你的QQ号作为油箱名称 QQ密码作为邮箱密码
            if (pop3.login("2014302580191@whu.edu.cn", "189@gy.com")) {

                POP3MessageInfo[] p3m = pop3.listMessages();

                System.out.println("您一共有" + p3m.length + "封信件");
                for (POP3MessageInfo obj : p3m) {
                    int id = obj.number;// 获得信件在服务器端的唯一编码

                    Reader red = pop3.retrieveMessage(id);
                    BufferedReader br = new BufferedReader(red);
                    while (br.readLine() != null) {
                        System.out.println(br.readLine());
                    }
                }
            }

            pop3.logout();
            pop3.disconnect();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("连接失败");
            e.printStackTrace();
        }

    }
}
