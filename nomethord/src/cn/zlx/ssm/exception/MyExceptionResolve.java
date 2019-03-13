package cn.zlx.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        MyException myException=null;
        if(e instanceof MyException){
            myException= (MyException) e;
        }else {
            myException=new MyException("未知错误");
        }
        String message=myException.getMessage();
        ModelAndView m=new ModelAndView();
        m.addObject("message",message);
        m.setViewName("error");
        return m;
    }
}
