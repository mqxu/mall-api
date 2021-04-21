package com.mqxu.mall.api.config;

import com.mqxu.mall.api.common.Constants;
import com.mqxu.mall.api.config.handler.TokenToMallUserMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mqxu
 */
@Configuration
public class MallWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private TokenToMallUserMethodArgumentResolver tokenToMallUserMethodArgumentResolver;

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

    //@Override
    //public void addCorsMappings(CorsRegistry registry) {
    //    registry.addMapping("/**").allowedOrigins("*")
    //            .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
    //            .allowCredentials(true).maxAge(3600);
    //}

    //@Bean
    //public CorsFilter corsFilter() {
    //    CorsConfiguration config = new CorsConfiguration();
    //    config.addAllowedOrigin("*");
    //    config.addAllowedMethod("*");
    //    config.addAllowedHeader("*");
    //    config.addExposedHeader("*");
    //    config.setMaxAge(3600L);
    //    config.setAllowCredentials(true);
    //    UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
    //    configSource.registerCorsConfiguration("/**", config);
    //    return new CorsFilter(configSource);
    //}
}
