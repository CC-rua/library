package cn.edu.hqu.library.advice;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "/error";

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ModelAndView handleIllegalParamException(HttpServletRequest request, HttpRequestMethodNotSupportedException ex){
        System.out.println("捕获异常HttpRequestMethodNotSupportedException");
        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception",ex);
//        mav.addObject("url",request.getRequestURL());
        mav.addObject("errorMsg","错误的访问系统服务，服务接口不存在");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ModelAndView handleNullPointerException(HttpServletRequest request, MissingServletRequestParameterException ex){
        System.out.println("捕获异常MissingServletRequestParameterException");
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg","参数错误：缺少服务所需要的参数");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView handleNullPointerException(HttpServletRequest request, NullPointerException ex){
        System.out.println("捕获异常NullPointerException");
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg","数据错误：服务所需要的数据不存在");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = HttpSessionRequiredException.class)
    public ModelAndView handleHttpSessionRequiredException(HttpServletRequest request, HttpSessionRequiredException ex){
        System.out.println("捕获异常HttpSessionRequiredException");
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg","登陆已过时，请重新登陆");
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
}
