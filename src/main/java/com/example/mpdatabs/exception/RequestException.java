package com.example.mpdatabs.exception;

/**
 * API请求业务异常类，就是当errno需要返回为1时，service层直接抛出异常即可
 * @author 周涛
 */
public class RequestException extends RuntimeException {

    public RequestException() {}

    public RequestException(String message) {
        super(message);
    }

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
