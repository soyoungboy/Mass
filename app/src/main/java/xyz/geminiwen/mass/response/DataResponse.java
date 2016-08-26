package xyz.geminiwen.mass.response;

/**
 * Created by geminiwen on 16/8/25.
 * SegmentFault Data Response
 */
public class DataResponse<T> {
    private int code;
    private T data;
    private String message;
    private int status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
