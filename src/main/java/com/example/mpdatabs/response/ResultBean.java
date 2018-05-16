package com.example.mpdatabs.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * API统一响应类
 * @param <T> : 转为JSON需要是JSON数组类型
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultBean<T> {

    /**失败状态码*/
    public static final int FAIL = 1;

    /**半失败状态码*/
    public static final int HALF_FAIL = 2;

    public static final int SUCCESS = 0;

    /**响应信息*/
    private String error = "succ";

    /**响应状态码*/
    private Integer errno = SUCCESS;

    /**响应数据*/
    private T data;

    /**使用该无参构造器,是初始化响应成功的ResultBean*/
    public ResultBean() {
        super();
    }

    /**使用该data参数构造器，是初始化ResultBean的data字段*/
    public ResultBean(T data) {
        super();
        this.data = data;
    }

    /**使用该异常参数构造器，是将异常码和异常信息初始化*/
    public ResultBean(Throwable e) {
        super();
        this.error = e.toString();
        this.errno = FAIL;
    }

    /**自定义错误码和错误信息*/
    public ResultBean(Integer errno, String error) {
        super();
        this.errno = errno;
        this.error = error;
    }

}