package com.mqxu.mall.api.interceptor;

import com.mqxu.mall.api.entity.MallLoginLog;
import com.mqxu.mall.api.service.MallLoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @description: 登录拦截器
 * @author: mqxu
 * @since: 2021-04-27
 **/
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private MallLoginLogService mallLoginLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求前调用！");
        String token = request.getHeader("token");
        //未登录，在日志里写入一条登录日志
        if (token.isEmpty()) {
            String platform = request.getHeader("platform");
            String userId = request.getHeader("userId");
            MallLoginLog mallLoginLog = MallLoginLog.builder()
                    .userId(Long.parseLong(userId))
                    .platform(platform)
                    .apiUri("/api/v1/user/login")
                    .createTime(new Date())
                    .build();
            log.info("日志：" + mallLoginLog);
            return mallLoginLogService.saveLog(mallLoginLog);
        } else {
            //已登录，在日志里写入具体访问的接口
            String requestUri = request.getRequestURI();
            String platform = request.getHeader("platform");
            String userId = request.getHeader("userId");
            MallLoginLog mallLoginLog = MallLoginLog.builder()
                    .userId(Long.parseLong(userId))
                    .platform(platform)
                    .apiUri(requestUri)
                    .createTime(new Date())
                    .build();
            log.info("日志：" + mallLoginLog);
            return mallLoginLogService.saveLog(mallLoginLog);
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
