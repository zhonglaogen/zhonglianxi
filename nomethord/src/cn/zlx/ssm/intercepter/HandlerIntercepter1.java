package cn.zlx.ssm.intercepter;

import cn.zlx.ssm.entity.User;
import cn.zlx.ssm.service.UserService;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HandlerIntercepter1 implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url=httpServletRequest.getRequestURI();
        if(url.indexOf("login.action")>=0 || url.indexOf("regist.action")>=0){
            System.out.println("包含index");
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        String userphone = (String) session.getAttribute("userphone");
        if(userphone!=null){
            System.out.println("usrrphone不等于空");
            return true;
        }
        System.out.println("页面跳转");
        httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
