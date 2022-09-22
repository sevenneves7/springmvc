package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) {// doGet()----service请求处理
        System.out.println("执行MyController中的doSome()方法");
        //处理some.do请求。
        ModelAndView mv=new ModelAndView();
//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
//        返回mv
        return mv;

    }

}
