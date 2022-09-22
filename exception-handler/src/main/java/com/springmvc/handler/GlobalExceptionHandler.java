package com.springmvc.handler;

import com.springmvc.exception.AgeException;
import com.springmvc.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice :控制器增强
 *      位置：在类的上面
 *      特点：必须让框架知道这个注解所在的包名，需要在SpringMVC配置文件声明组件扫描器，指定@controllerAdvice所在的包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//    定义方法处理发生的异常
    /**
     * 处理异常的方法和控制器方法的定义一样，可以由多个参数，可以由ModelAndView，String，void，对象类型的返回值
     * 形参：Exception，表示Controller中抛出的异常对象。通过形参可以获取发生的异常信息
     * @ExceptionHandler ：表示异常的类型，当发生此类型异常时，由当前方法处理
     */

    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception ex){
//        处理NameException的异常
        /**
         * 异常发生处理逻辑
         *  1.把异常记录下来，记录到数据库，日志文件
         *  2.发送通知，把异常信息发送给相关人员
         *  3.给用户友好的提示
         */
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","姓名必须是coin，其他用户不能访问");
        mv.addObject("ex",ex);
        mv.setViewName("nameError");
        return mv;
    }

//    处理AgeException
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception ex){
//        处理AgeException的异常
        /**
         * 异常发生处理逻辑
         *  1.把异常记录下来，记录到数据库，日志文件
         *  2.发送通知，把异常信息发送给相关人员
         *  3.给用户友好的提示
         */
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","你的年龄不能大于80");
        mv.addObject("ex",ex);
        mv.setViewName("ageError");
        return mv;
    }

//    处理其他异常，NameException，AgeException以外的异常
    @ExceptionHandler
    public ModelAndView doOtherException(Exception ex){
    //        处理OtherException的异常
        /**
         * 异常发生处理逻辑
         *  1.把异常记录下来，记录到数据库，日志文件
         *  2.发送通知，把异常信息发送给相关人员
         *  3.给用户友好的提示
         */
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","其他类型异常");
        mv.addObject("ex",ex);
        mv.setViewName("defaultError");
        return mv;
    }
}
