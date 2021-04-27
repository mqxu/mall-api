package com.mqxu.mall.api.config;

import com.mqxu.mall.api.common.Constants;
import com.mqxu.mall.api.config.handler.TokenToMallUserMethodArgumentResolver;
import com.mqxu.mall.api.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mqxu
 * @description: WebMvc配置
 */
@Configuration
public class MallWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private TokenToMallUserMethodArgumentResolver tokenToMallUserMethodArgumentResolver;

    @Resource
    private LogInterceptor logInterceptor;

    /**
     * TokenToMallUser 注解处理方法
     *
     * @param argumentResolvers 参数解析器
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(tokenToMallUserMethodArgumentResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:" + Constants.FILE_UPLOAD_DIC);
    }

    /**
     * 注册拦截器
     *
     * @param registry 拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求，除了swagger
        registry.addInterceptor(logInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
}
