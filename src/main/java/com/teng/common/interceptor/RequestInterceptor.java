package com.teng.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.teng.Utils.RequestUtils;
import com.teng.Utils.ResponseUtils;
import com.teng.model.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by admin on 2018/1/3.
 */
public class RequestInterceptor implements HandlerInterceptor {

        private Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
                // TODO Auto-generated method stub
                logger.info("------preHandle------");
                //获取session
                Customer customer = RequestUtils.getCurrentUserByRequest(request);
                //判断用户ID是否存在，不存在就跳转到登录界面
                if(customer == null){
                        logger.info("------:登录超时或未登录，跳转到login页面！");
                        response.getWriter().write(JSON.toJSONString(ResponseUtils.unlogin()));
                        return false;
                }else{
                        RequestUtils.setCurrentUser(customer);
                        return true;
                }
        }

        @Override
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        }


        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
                throws Exception {
                // TODO Auto-generated method stub

        }
}
