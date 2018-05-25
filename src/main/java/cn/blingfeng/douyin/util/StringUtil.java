package cn.blingfeng.douyin.util;

public class StringUtil {
    private static final String BRG_PRE_URL = "cover: ";
    private static final String PRE_PLAYURL = "https://aweme.snssdk.com/aweme/v1/play/?video_id=";
    private static final String TARGET = "playwm";
    private static final String REPLACE_STR = "play";

    public static String getPlayUrl(String url) {
        url = url.replace(TARGET, REPLACE_STR);
        int start = url.indexOf(PRE_PLAYURL);
        int end = url.indexOf(",", start) - 1;
        return url.substring(start, end);
    }

    public static String getBackground(String url) {
        int brgIdx = url.indexOf(BRG_PRE_URL) + BRG_PRE_URL.length() + 1;
        return url.substring(brgIdx, url.indexOf('"', brgIdx));
    }
}
