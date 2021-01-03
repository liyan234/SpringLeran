package org.example.demoprojectSpring.handler;

import org.example.demoprojectSpring.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
* 标记这是一个异常处理器
* */
// 返回信息
@RestControllerAdvice
//可以用来返回页面
//@ControllerAdvice
public class CustomExHandler {

    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request) {
        //返回一个数据
        return JsonData.buildError(-2, "服务端出错了");
        // 返回一个页面
       /* ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        return modelAndView;*/
    }
}
