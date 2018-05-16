package com.example.mpdatabs.aop;

import com.example.mpdatabs.exception.RequestException;
import com.example.mpdatabs.exception.ResponseTwoException;
import com.example.mpdatabs.response.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Controller层响应的AOP实现,用于返回响应和打印日志，捕获异常
 * @author 周涛
 */
@Aspect
@Component
public class ResponseAop {
    private static final Logger log = LoggerFactory.getLogger(ResponseAop.class);

    /**定义切点,切的是ResultBean*/
    @Pointcut("execution(public com.example.mpdatabs.response.ResultBean *(..))")
    public void controllerMethod() {}

    @Around(value = "controllerMethod()")
    public ResultBean<?> handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        ResultBean<?> result;

        try {
            // 执行被通知的方法调用
            result = (ResultBean<?>) pjp.proceed();
            // pjp.getsignature()指的是获取调用方法的签名
            log.info(pjp.getSignature() + " use time :" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerControllerException(pjp, e);
        }

        return result;
    }

    /**
     * 处理异常结果
     * @param pjp
     * @param e 异常
     * @return
     */
    private ResultBean handlerControllerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean result = new ResultBean<>();

        // 已知异常
        if (e instanceof RequestException) {
            // getLocalizedMessage是可以国际化；用getMessage也可以
            result.setError(e.getLocalizedMessage());
            result.setErrno(ResultBean.FAIL);
        } else if (e instanceof ResponseTwoException) {
            result.setErrno(ResultBean.HALF_FAIL);
            result.setError(e.getMessage());
        } else {
            // 未知异常，需要打印日志
            log.error(pjp.getSignature() + "error ", e);
            //TODO 未知的异常，应该格外注意，此处可加入邮件通知功能

            result.setError(e.toString());
            result.setErrno(ResultBean.FAIL);
        }

        return result;
    }
}
