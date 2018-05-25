package cn.blingfeng.douyin.web;

import cn.blingfeng.douyin.pojo.DouyinResult;
import cn.blingfeng.douyin.util.StringUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController("parser")
public class DouyinController {
    @PostMapping()
    public DouyinResult parserUrl(String url) {
        BufferedReader in = null;
        String playUrl = null;
        String brgUrl = null;
        Map<String, String> result = Collections.EMPTY_MAP;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            playUrl = StringUtil.getPlayUrl(sb.toString());
            brgUrl = StringUtil.getBackground(sb.toString());
            result = new HashMap<String, String>();
            result.put("playUrl", playUrl);
            result.put("brgUrl", brgUrl);
        } catch (Exception e) {
            return DouyinResult.fail(e.getMessage(), 500);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return DouyinResult.success(result);
    }
}
