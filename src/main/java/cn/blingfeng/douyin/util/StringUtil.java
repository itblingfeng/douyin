package cn.blingfeng.douyin.util;

public class StringUtil {
    private static final String PRE_URL = "https://aweme.snssdk.com/aweme/v1/play/?";
    private static final String BRG_PRE_URL = "https://p1.pstatp.com/large/";

    public static String getPlayUrl(String url) {
        int videoIdx = url.indexOf("video_id");
        return PRE_URL + url.substring(videoIdx, url.indexOf('"', videoIdx));
    }

    public static String getBackground(String url) {
        int brgIdx = url.indexOf(BRG_PRE_URL);
        return url.substring(brgIdx, url.indexOf('"', brgIdx));
    }
}
