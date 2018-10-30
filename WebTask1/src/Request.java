import java.io.IOException;
import java.io.InputStream;

/**
 * 接收请求
 * Created by BG on 2017/4/18.
 */
public class Request {

    private InputStream input;
    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parser() {

        StringBuffer request = new StringBuffer();
        byte[] buffer = new byte[1024];           // 应该够用了吧
        int i = 0;

        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }

        for(int k = 0; k < i; k++) {
            request.append((char)buffer[k]);
        }

        uri = parserUri(request.toString());

    }

    private String parserUri(String requestData) {
        int index1, index2;
        index1 = requestData.indexOf(' ');
        if(index1 != -1) {
            index2 = requestData.indexOf(' ', index1 + 1);
            if(index2 > index1) {
                return requestData.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
