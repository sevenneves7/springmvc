package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping :
 *  value：所有请求地址的公共部分，叫做模块名称.下面代码中即"/test"
 *  位置：放在类的上面
 */

@Controller
@RequestMapping("/test")
public class MyController {

    /**
     * @RequestMapping :请求映射
     *      属性：method  表示请求方式。值是RequestMethod类的枚举值
     *      例如表示get请求方式，RequestMethod.GET
     *          表示post请求方式，RequestMethod.POST
     * @return
     */
//    指定some.do使用get请求方式
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome(){// doGet()----service请求处理
        //处理some.do请求。
        ModelAndView mv=new ModelAndView();
//        添加数据,框架在请求的最后把数据放入到request作用域
        mv.addObject("msg","欢迎使用SpringMVC做Web开发");
        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("show");

//        返回mv
        return mv;

    }
//    指定other.do使用post请求
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC做Web开发");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");

//        返回mv
        return mv;

    }
//    不指定请求方式，没有限制
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv=new ModelAndView();
        mv.addObject("msg","欢迎使用SpringMVC做Web开发"+request.getParameter("name"));
        mv.addObject("fun","执行的是doFirst方法");
        mv.setViewName("other");

//        返回mv
        return mv;

    }
}
