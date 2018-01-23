package com.teng.common.config;

import com.teng.common.interceptor.RequestInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by admin on 2018/1/3.
 */
@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {

        private ApplicationContext applicationContext;

        public WebConfig(){
                super();
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static/");
                registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/");
                super.addResourceHandlers(registry);
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                this.applicationContext = applicationContext;
        }
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
                //拦截规则：除了login，获取验证码，注册，锁定用户，忘记密码等，其他都拦截判断
                registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**").excludePathPatterns(new String[]{"/login", "/registed","/getCode","/lockCus","/forget"});
                super.addInterceptors(registry);
        }

}