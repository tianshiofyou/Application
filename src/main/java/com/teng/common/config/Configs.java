package com.teng.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configs {
        /**
         * 更改默认的Json解析为FastJson
         * @return
         */
        @Bean
        public HttpMessageConverters fastJsonHttpMessageConverters() {
                FastJsonHttpMessageConverter oFastConverter = new FastJsonHttpMessageConverter();
                FastJsonConfig oFastJsonConfig = new FastJsonConfig();
                oFastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
                oFastConverter.setFastJsonConfig(oFastJsonConfig);
                //处理中文乱码问题
                List<MediaType> oFastMediaTypeList = new ArrayList<>();
                oFastMediaTypeList.add(MediaType.APPLICATION_JSON_UTF8);
                oFastConverter.setSupportedMediaTypes(oFastMediaTypeList);

                HttpMessageConverter<?> oConverter = oFastConverter;
                return new HttpMessageConverters(oConverter);
        }

}
