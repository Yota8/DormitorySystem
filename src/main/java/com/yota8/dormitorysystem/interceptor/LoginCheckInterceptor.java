package com.yota8.dormitorysystem.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.yota8.dormitorysystem.bean.Result;
import com.yota8.dormitorysystem.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求url
        String url = request.getRequestURL().toString();
        log.info("请求的url: {}",url);

        // 判断url中是否包含login,如果包含则放行
        if (url.contains("Login")) {
            return true;
        }

        // 获取请求头中的令牌
        // 前端中,跳转时将jwtToken携带进header里,每次跳转页面通过拦截器时,才可以通过jwt校验
        String jwt = request.getHeader("jwtToken");

        //        废弃测试代码
        //        if (request.getHeader("jwtToken") == null) {
        //            response.sendRedirect("/StudentLogin");
        //            return false;
        //        }

        // 经过调试,前端axios传过来的header中的jwtToken是字符串,会多出两个""引号,需要去除这两个引号,否则会报jwt令牌不对应的错误,花了一个小时这里
        if (jwt != null) {
            jwt = jwt.replace("\"","");
        }

        // 判断令牌是否存在，不存在则返回(未登录)的错误结果
        if (!StringUtils.hasLength(jwt)){
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);   //通过response响应给浏览器
            return false;
        }

        // 解析token,如果解析失败,返回错误结果(令牌解析错误)
        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败,返回令牌解析错误信息");
            Result error = Result.error("PARSE_ERROR");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);   //通过response响应给浏览器
            return false;
        }

        log.info("令牌合法,放行");
        return true;
    }
}
