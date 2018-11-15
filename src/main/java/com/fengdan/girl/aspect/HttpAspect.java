package com.fengdan.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * aop
 *
 * @Author ibout
 * @Create 2018-05-24 on 13:39
 *
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义一个公用的方法
     */
    @Pointcut("execution(public * com.fengdan.girl.controller.*.*(..))")
    public void log() {
    }


    /**
     * 执行controller方法之前执行
     */

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("执行controller方法之前执行");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", "请求的url路径:" + request.getRequestURL());

        //method
        logger.info("method_Type={}", "请求方法的类型:" + request.getMethod());

        //ip
        logger.info("ip={}", "请求的ip地址:" + request.getRemoteAddr());

        //类方法
        logger.info("package_class_method={}", "包下面的类:" + joinPoint.getSignature().getDeclaringTypeName() + ",具体的方法:" + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

    }

    /**
     * 执行controller方法之后执行
     */
    @After("log()")
    public void doAfter() {
        logger.info("执行controller方法之后执行");
    }


    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", "请求返回的结果:"+object.toString());
    }
}
