package com.lne.kafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.nio.charset.StandardCharsets;

/**
 * 配置路径参数
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        UrlPathHelper helper = new UrlPathHelper();
        helper.setUrlDecode(false);
        helper.setDefaultEncoding(StandardCharsets.UTF_8.name());
        configurer.setUrlPathHelper(helper);
    }
}
