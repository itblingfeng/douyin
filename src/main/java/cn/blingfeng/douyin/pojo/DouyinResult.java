package cn.blingfeng.douyin.pojo;

import lombok.Data;

@Data
public class DouyinResult {
    private String msg;
    private Object data;
    private int code;

    private DouyinResult(String msg, Object data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public static DouyinResult success() {
        return new DouyinResult("success", null, 200);
    }

    public static DouyinResult success(Object data) {
        return new DouyinResult("success", data, 200);
    }

    public static DouyinResult fail(int code) {
        return new DouyinResult("fail", null, code);
    }

    public static DouyinResult fail(String msg, int code) {
        return new DouyinResult(msg, null, code);
    }
}
