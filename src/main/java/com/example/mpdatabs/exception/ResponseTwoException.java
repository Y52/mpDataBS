package com.example.mpdatabs.exception;

/**
 * API调用需要返回值为2时，service层直接抛出该异常即可
 * @author 周涛
 */
public class ResponseTwoException extends RuntimeException {

    public ResponseTwoException() {
        super();
    }

    public ResponseTwoException(String message) {
        super(message);
    }

    public ResponseTwoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseTwoException(Throwable cause) {
        super(cause);
    }

    protected ResponseTwoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
