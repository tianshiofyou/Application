package com.teng.common.aop.log;

import com.alibaba.fastjson.JSON;
import com.teng.Utils.RequestUtils;
import com.teng.model.builder.CusLogBuilder;
import com.teng.event.CusOprateLogEvent;
import com.teng.model.CusLog;
import com.teng.model.ResponseMsg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by admin on 2017/12/31.
 */
@Component
@Aspect
public class RequestLog {
        private Logger logger = LoggerFactory.getLogger(getClass());
        ThreadLocal<StopWatch> startTime = new ThreadLocal<StopWatch>();
        @Autowired
        ApplicationContext applicationContext;
        @Pointcut("execution(public * com.teng.web..*.*(..))")
        public void webLog(){

        }
        @Before("webLog()")
        public void doBefore(JoinPoint joinPoint) throws Throwable {
                startTime.set(new StopWatch());
                startTime.get().start();
                // 省略日志记录内容
                logger.info("请求进入");
                logger.info(joinPoint.getSignature().getName());
        }
        @AfterReturning(returning = "ret", pointcut = "webLog()")
        public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
                logger.info("返回值：" + JSON.toJSONString(ret));
                // 处理完请求，返回内容
                startTime.get().stop();
                long expendTimes = startTime.get().getTotalTimeMillis();
                logger.info("SPEND TIME : " + expendTimes);
                // 接收到请求，记录请求内容
                HttpServletRequest request = RequestUtils.getRequest();

                // 记录下请求内容
                logger.info("URL : " + request.getRequestURL().toString());
                logger.info("URI : " + request.getRequestURI().toString());
                logger.info("HTTP_METHOD : " + request.getMethod());
                logger.info("IP : " + request.getRemoteAddr());
                logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
                logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

                /* 通过反射获取RequestMapping的值，继而获取接口名
                Signature signature = joinPoint.getSignature();
                MethodSignature methodSignature = (MethodSignature)signature;
                Method targetMethod = methodSignature.getMethod();
                RequestMapping mapping = targetMethod.getAnnotation(RequestMapping.class);
                logger.info("RequestMapping -> " + mapping.value());*/
                if (ret instanceof  ResponseMsg){
                        ResponseMsg msg = (ResponseMsg) ret;
                        msg.getMsg();
                        CusLog log = CusLogBuilder.parse(new CusLog())
                                .interfaceName(request.getRequestURI().toString())
                                .loginName(RequestUtils.getCurrentUser().getLoginName())
                                .ipAddress(RequestUtils.getIpAddr())
                                .invokeTimes(new Date())
                                .expendTimes(expendTimes)
                                .invokeResult(msg.getMsg())
                                .requestData(JSON.toJSONString(joinPoint.getArgs()))
                                .responseData(JSON.toJSONString(msg))
                                .remark("")
                                .getLog();
                        applicationContext.publishEvent(new CusOprateLogEvent(log));
                }





        }
        @After("webLog()")
        public void doAfter(JoinPoint joinPoint) throws Throwable{

        }
}
