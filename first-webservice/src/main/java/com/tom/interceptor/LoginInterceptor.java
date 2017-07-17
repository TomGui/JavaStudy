package com.tom.interceptor;

import com.tom.entity.Administrator;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public String[] allowUrls;//还没发现可以直接配置不拦截的资源，所以在代码里面来排除

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI();
        //获取请求的url
        if (null != allowUrls && allowUrls.length >= 1) {
            for (String url : allowUrls) {
                if (requestUrl.contains(url)) {
                    return true;
                }
            }
        }

        HttpSession session = request.getSession();
        Administrator administrator = (Administrator) session.getAttribute("currentLoginUser");
        if (administrator != null) {
            return true;
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
