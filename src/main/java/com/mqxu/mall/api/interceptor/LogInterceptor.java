package com.mqxu.mall.api.interceptor;

import com.mqxu.mall.api.common.Constants;
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
 * @description: 日志拦截器
 * @author: mqxu
 * @since: 2021-04-27
 **/
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Resource
    private MallLoginLogService mallLoginLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求前调用！");
        String platform = request.getHeader("platform");
        String userId = request.getHeader("userId");
        String token = request.getHeader("token");
        //请求头没有带platform，拦回，不走接口
        if ("".equals(platform)) {
            return false;
        }
        //客户端如访问注册、登录、首页接口，放行
        if (Constants.API_LOGIN.equals(request.getRequestURI()) || Constants.API_REGISTER.equals(request.getRequestURI()) || Constants.API_INDEX.equals(request.getRequestURI())) {
            return true;
        }
        // 走到这里，证明有platform、也不是访问注册登录首页接口，则检测token是否有值
        //根据请求头中token是否为""，决定是否放行到接口
        return !"".equals(token);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("调用接口" + request.getRequestURI() + "完毕");
        String userId = request.getHeader("userId");
        MallLoginLog mallLoginLog;
        mallLoginLog = MallLoginLog.builder()
                .platform(request.getHeader("platform"))
                .apiUri(request.getRequestURI())
                .createTime(new Date())
                .build();
        //登录后带有userId请求头访问的日志
        if (!"".equals(userId)) {
            mallLoginLog.setUserId(Long.parseLong(userId));
        }
        log.info("保存日志：" + mallLoginLog);
        mallLoginLogService.saveLog(mallLoginLog);
    }
}
