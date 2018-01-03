package com.teng.Utils;

import com.teng.entity.Customer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/12/27.
 */
public class RequestUtils {


        public static HttpServletRequest getRequest(){
                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = attributes.getRequest();
                return request;
        }

        /**
         * 获取访问者IP
         *
         * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
         *
         * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
         * 如果还不存在则调用Request .getRemoteAddr()。
         * @return request
         */
        public static String getIpAddr(){
                HttpServletRequest request = getRequest();
                String ip = request.getHeader("X-Real-IP");
                if (!Strings.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
                        return ip;
                }
                ip = request.getHeader("X-Forwarded-For");
                if (!Strings.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
                        // 多次反向代理后会有多个IP值，第一个为真实IP。
                        int index = ip.indexOf(',');
                        if (index != -1) {
                                return ip.substring(0, index);
                        } else {
                                return ip;
                        }
                } else {
                        return request.getRemoteAddr();
                }
        }

        public static Customer getCurrentUser(){
                HttpServletRequest request = getRequest();
                return (Customer) request.getSession().getAttribute("Customer");
        }

        public static Customer getCurrentUserByRequest(HttpServletRequest request){
                return (Customer) request.getSession().getAttribute("Customer");
        }

        public static void setCurrentUser(Customer customer){
                HttpServletRequest request = getRequest();
                request.getSession().setAttribute("Customer", customer);
        }

}
