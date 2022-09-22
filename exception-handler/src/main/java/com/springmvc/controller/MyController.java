package com.springmvc.controller;

import com.springmvc.exception.AgeException;
import com.springmvc.exception.MyUserException;
import com.springmvc.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age)throws MyUserException {// doGet()----service请求处理
        //处理some.do请求。
        ModelAndView mv=new ModelAndView();

//        根据请求参数抛出异常
        if(!"coin".equals(name)){
            throw new NameException("姓名不正确!!!");
        }
        if(age==null||age>80){
            throw new AgeException("年龄过大!!!");
        }

//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");

//        返回mv
        return mv;

    }

}
